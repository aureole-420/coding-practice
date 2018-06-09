package algorithm_bfs_dfs;

import java.util.*;
// https://leetcode.com/problems/alien-dictionary/description/
// 构建一个有向图, 从前向后扫扫描
// 这题太tricky了！
// 思路很简单，phase I， 转化图 phase II， topological sort
// 转化图那里非常tricky，一定要先buildNode （不然会漏掉节点），再build edges
public class LeetCode269_hard_AlientDictionary {
    public String alienOrder(String[] words) {
    		//corner case
    		if (words == null || words.length == 0) {
    			return "";
    		}
    		
    		HashMap<Character, HashSet<Character>> graph = new HashMap<>();
    		for (String word: words) {
    			buildNode(word, graph);
    		}
    		
    		for (int i = 0; i+1 < words.length; i++) {
    			buildEdge(words[i], words[i+1], graph);
    		}
    		
    		HashMap<Character, Boolean> visited = new HashMap<>();
    		HashMap<Character, Boolean> inCallStack = new HashMap<>();
    		
    		for (Character c: graph.keySet()) {
    			visited.put(c, false);
    			inCallStack.put(c, false);
    		}
    		
    		StringBuilder postOrder = new StringBuilder();
    		
    		for (Character c: graph.keySet()) {
    			if (dfs(c, graph, visited, inCallStack, postOrder)) { // has cycle
    				System.out.println("cycle found");
    				return "";
    			}
    		}
    		
   
    		return postOrder.toString();
    }
    
    // return: true -- hasCycle, false otherwise 
    private boolean dfs(char c, HashMap<Character, HashSet<Character>> graph, 
    						HashMap<Character, Boolean> visited, 
    						HashMap<Character, Boolean> inCallStack,
    						StringBuilder postOrder) {
    		System.out.println("dfs being called");
    	
    		if (visited.get(c)) {
    			return false;
    		}
    		
    		visited.put(c, true);
    		inCallStack.put(c, true);
    		for (Character neighbor: graph.get(c)) {
    			if (visited.get(neighbor) && inCallStack.get(neighbor)) { // cycle found [neighbor =>....=> c => neighbor]
    				return true;
    			}
    			if (dfs(neighbor, graph, visited, inCallStack, postOrder)) { // if cycle found 
    				return true;
    			}
    		}
    		inCallStack.put(c, false);
    		postOrder.insert(0,  c);
    		
    		return false;
    		
    }
    
    private void buildNode(String word, HashMap<Character, HashSet<Character>> graph) {
    		for (Character c : word.toCharArray()) {
    			if (!graph.containsKey(c)) {
    				graph.put(c, new HashSet<Character>());
    			}
    		}
    }
    
    // 非常tricky 每个字母都得记下来！！！！ [ab, adc], 字母c也要记下来！
    private void buildEdge(String w1, String w2, HashMap<Character, HashSet<Character>> graph) {
    		if (w1 == null || w2 == null) { // 这里有个trick， w1==w2并不能把跳过，还是得把每个字母先记下来
    			return;
    		}
    		for (int i = 0; i < w1.length() && i < w2.length(); i++) { 
    			char smChar = w1.charAt(i); // tricky 2， 每个字母都先记下来； 如果有必要再build edge
    			char lgChar = w2.charAt(i);
    			
    			if (smChar != lgChar) {
    				graph.get(smChar).add(lgChar);
    				return;
    			}
    		}
    		
    }
    
    public static void main(String[] args) {
//    		StringBuilder sb = new StringBuilder();
//    		sb.insert(0, 'a');
//    		sb.insert(0, 'b');
//    		sb.insert(0, 'c');
//    		
//    		System.out.println(sb.toString()); // should be "cba" if 
    	
//    		String[] sarr = new String[] {"wrt","wrf","er","ett","rftt"};
//    	    	String[] sarr = new String[] {"ab","adc"};
    		String[] sarr = new String[] {"wnlb"};
    		LeetCode269_hard_AlientDictionary ad = new LeetCode269_hard_AlientDictionary();
    		String res = ad.alienOrder(sarr);
    		System.out.println(res);
    }
}
