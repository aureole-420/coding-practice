package algorithm_dp;

import java.util.*;
// 与 palindrom partition II 类似

// states: f[i] 【前i个字符】组成的string能否被word break
// init： f[0] = true;
//transfer function: f[i] = OR{f[j]} j < i && j+1~i in wordDict
public class LeetCode139_medium_WordBreak {
	
	
    public boolean wordBreak(String s, List<String> wordDict) {
        
    	int N = s.length();
    	int maxLen = 0;
    	HashSet<String> dict = new HashSet<>();
    	for (String word : wordDict) {
    		maxLen = Math.max(word.length(), maxLen);
    		dict.add(word);
    	}
    	
    	// states
    	boolean[] f = new boolean[N+1];
    	
    	// init 
    	f[0] = true;
    	
    	// transfer
    	for (int i = 1; i <= N; i++) {
    		for (int j = Math.max(0, i-maxLen); j < i; j++) {
    			if (f[j] && inWordDict(s, j+1, i, dict)) {
    				f[i] = true;
    				break;
    			}
    		}
    	}
    		
    		
    	// result
    	return f[N];
    	
    }
    
    private boolean inWordDict(String s, int start, int end, HashSet<String> dict) {
    	String temp = s.substring(start-1, end);
    	return dict.contains(temp);
    }
}
