package intuit_oa;

import sun.security.krb5.Config;

import java.io.*;
import java.util.*;


public class Solution {

    static class ConfigNode {
        String name;
        String parentName;
        HashMap<String, String> config;
        List<ConfigNode> childrenNode;
        List<ConfigNode> ancestors;
        ConfigNode parentNode;
        ConfigNode(String s) {
            name = s;
            parentName = null;
            config = new HashMap<>();
            childrenNode = new ArrayList<>();
            parentNode = null;
            ancestors = new ArrayList<>();
        }
    }

    // If you need extra classes, you can define them privately here within class Solution

    static void parseConfiguration(List<String> configurationLines) {
        ConfigNode rootNode = new ConfigNode("root");
        HashMap<String, ConfigNode> allConfigs = new HashMap<>();
        allConfigs.put("root", rootNode);
        buildTree(configurationLines, allConfigs);

        // find all ancestors for each node.
        dfs(rootNode, new ArrayList<ConfigNode>());

        // output
        List<String> sortedConfigNames = new ArrayList<>(allConfigs.keySet());
        Collections.sort(sortedConfigNames);
        for (int i = 0; i < sortedConfigNames.size(); i++) {
            String configName = sortedConfigNames.get(i);
            if (configName.equals("root")) {
                continue;
            }
            outputSingleConfig(configName, allConfigs);

            if (i != sortedConfigNames.size()-1) {
                System.out.println("");
            }
        }
    }

    static void outputSingleConfig(String name, HashMap<String, ConfigNode> allConfigs) {
        System.out.println("[" + name + "]");

        ConfigNode cur = allConfigs.get(name);

        HashMap<String, String> curConfig = new HashMap<>();
        for (String key : cur.config.keySet()) {
            curConfig.put(key, cur.config.get(key));
        }
        for (ConfigNode ances : cur.ancestors) {
            for (String key : ances.config.keySet()) {
                if (!curConfig.containsKey(key)) {
                    curConfig.put(key, ances.config.get(key));
                }
            }
        }

        List<String> sortedKeys = new ArrayList<String>(curConfig.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            System.out.println(key + " = " + curConfig.get(key));
        }
    }

    static void dfs(ConfigNode rootNode, List<ConfigNode> list) {

        // always insert the bottom first
        rootNode.ancestors = new ArrayList<>(list);
//        list.add(rootNode);
        list.add(0, rootNode);
        for (ConfigNode child : rootNode.childrenNode) {
            dfs(child, list);
        }
        list.remove(0);
    }

    static void buildTree(List<String> configurationLines, HashMap<String, ConfigNode> allConfigs) {
        boolean configStart = false;
        ConfigNode cur = null;

        // processLines
        for (String line : configurationLines) {
            line = line.trim();

            if (line.length() == 0) { // empty line
                continue;
            }

            if (line.charAt(0) == '[') { // found a config

                line = line.substring(1, line.length()-1);
                String[] names = line.split(":");
                String name = null, parentName = null;
                if (names.length == 2) {
                    name = names[0].trim();
                    parentName = names[1].trim();
                } else {
                    name = names[0].trim();
                }
                cur = new ConfigNode(name);
                cur.parentName = parentName;
                allConfigs.put(name, cur);
                continue;
            }

            // ordinary lines
            String[] temp = line.split("=");
            String key = temp[0].trim();
            String val = temp[1].trim();
            cur.config.put(key, val);
        }

        // build the tree
        ConfigNode rootNode = allConfigs.get("root");
        for (String name : allConfigs.keySet()) {
            if (name == "root") {
                continue;
            }
            ConfigNode curConfig = allConfigs.get(name);
            ConfigNode parentConfig = curConfig.parentName == null ? rootNode : allConfigs.get(curConfig.parentName);

            curConfig.parentNode = parentConfig;
            parentConfig.childrenNode.add(curConfig);
        }
    }


    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();

        String line;
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/yuhuitong/eclipse-workspace/coding-practice/src/intuit_oa/data.txt"));
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        parseConfiguration(input);
    }
}
