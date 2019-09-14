package fall_2019.microsoft;

import java.util.*;

public class leetcode269_hard_aliennDictionary {

    public String alienOrder(String[] words) {
        HashSet<Character> chars = new HashSet<>();
        HashSet<Character> visited = new HashSet<>();
        int[] indegree = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars.add(c);
            }
        }

        HashMap<Character, Set<Character>> graph = new HashMap<>();
        for (char c : chars) {
            graph.put(c, new HashSet<Character>());
        }

        // build graph
        for (int i = 0; i+1 < words.length; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int idx = 0;
            while (idx < Math.min(w1.length(), w2.length())) {
                if (w1.charAt(idx) == w2.charAt(idx)) {
                    idx++;
                } else {
                    break;
                }
            }

            if (idx < Math.min(w1.length(), w2.length())) {
                char smaller = w1.charAt(idx);
                char greater = w2.charAt(idx);

                visited.add(smaller);
                visited.add(greater);
                if (!graph.get(smaller).contains(greater)) { // 如果有重复的边的话，indegree并不增加。
                    graph.get(smaller).add(greater);
                    indegree[greater-'a']++;
                }
//                System.out.println("smaller=" + smaller + " greater=" + greater);
            }
        }


        // bfs
        Queue<Character> q = new LinkedList<>();
        for (char c : visited) {
            if (indegree[c-'a'] == 0) {
                System.out.println("c = " + c);
                q.offer(c);
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            System.out.println("cur =" + cur);
            sb.append(cur);
            count++;
            for (char adj : graph.get(cur)) {
                if (adj == cur) continue;
                indegree[adj-'a']--;
//                System.out.println("adj="+adj+" indegree[adj]="+indegree[adj-'a']);
                if (indegree[adj-'a'] == 0) {
                    q.offer(adj);
                }
            }
        }
        if (count < visited.size()) { // find cycle.
//            System.out.println("count = " + count + " size" + visited.size());
            return "";
        }

        for (char c : chars) {
            if (!visited.contains(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        leetcode269_hard_aliennDictionary ad = new leetcode269_hard_aliennDictionary();
//        String[] words = new String[] {  "wrt", "wrf", "ery", "ett", "rftt"};
        String[] words = new String[] {"za","zb","ca","cb"};
        System.out.println(" "+ad.alienOrder(words));
    }
}
