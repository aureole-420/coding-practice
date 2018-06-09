package algorithm_bfs_dfs;

import java.util.*;
//https://leetcode.com/problems/word-ladder/description/
// 思考，这题可以用trie吗？

// 所有单词之间的联系构成一个graph：(之差一个字母的单词由edge相连)
// word ladder即是找出最短连结undirected graph的最短路线。
// 简单的bfs traversal，看target word在哪一个level
public class LeetCode120_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
        		return 0;
        }

        
        // use a queue for bfs:
        Queue<String> queue = new LinkedList<>();
        Set<String> marked = new HashSet<>();
       
        queue.offer(beginWord);
        marked.add(beginWord);
        int level = 1;
        int numOfCurLevel = 1;
        
        while (!queue.isEmpty()) {
        	
        		if (numOfCurLevel == 0) {
        			numOfCurLevel = queue.size();
        			level++;
        		}
        		
        		String cur = queue.poll();
        		numOfCurLevel--;
        		if (cur.equals(endWord)) {
        			return level;
        		}
//        		wordList.remove(cur);
        		
        		
        	
        		for (String s : wordList) {
        			if (!marked.contains(s)) {
        				if (isAdjacent(cur, s)) {
        					queue.offer(s);
        					marked.add(s);
        				}
        			}
        		
        		}
        }
        
        return 0;
        
    }
    
    private boolean isAdjacent(String a, String b) {
    		if (a == null || b == null || a.length() != b.length()) {
    			return false;
    		}
    		
    		int diff = 0;
    		for (int i = 0; i < a.length(); i++) {
    			if (a.charAt(i) != b.charAt(i)) {
    				diff++;
    			}
    		}
    		
    		return diff == 1 ? true : false;
    }
    
    public static void main(String[] args) {
    		List<String> list = new LinkedList<String>();
    		list.add("abc");
    		list.add("bcd");
    		
    		System.out.println(list.size());
    		
    		String s = "abc";
    		list.remove(s);
//    		list.remove("fefe");
    		
    		System.out.println(list.size());

    } 
}
