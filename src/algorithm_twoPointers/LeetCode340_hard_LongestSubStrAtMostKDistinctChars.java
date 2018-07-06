package algorithm_twoPointers;

import java.util.HashMap;

// 跟157如出一辙
// 1. 把2换成参数k 2.加上一个k==0的corner case 
public class LeetCode340_hard_LongestSubStrAtMostKDistinctChars {
	
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    		// corner case
    		if (s == null || s.length() == 0 || k == 0) { // 注意k=0时的corner case
    			return 0;
    		}
    	
        HashMap<Character, Integer> map = new HashMap<>();
        
        char[] arr = s.toCharArray();
        int start = 0, end = 0;
        addChar(map, arr[start]);
        
        int maxLen = -1;
        for (;start < arr.length; start++) {
        		if (start > 0) {
        			removeChar(map, arr[start-1]);
        		}
        		
        		while (true) { // find the end for this start;
        			int potentialEnd = end+1;
        			if (potentialEnd < arr.length) {
        				addChar(map, arr[potentialEnd]);
        				if (map.size() > k) {
        					removeChar(map, arr[potentialEnd]);
        					break;
        				} else {
        					end = potentialEnd;
        				}
        			} else {
        				break;
        			}
        		}
        		
        		maxLen = Math.max(maxLen, end-start+1);
        }
        
        return maxLen;
    }
    
    private void addChar(HashMap<Character, Integer> map, char c) {
    		map.put(c, map.getOrDefault(c, 0) + 1);
    }
    
    private void removeChar(HashMap<Character, Integer> map, char c) {
    		if (map.get(c) == 1) {
    			map.remove(c);
    		} else {
    			map.put(c, map.get(c)-1);
    		}
    }
    
    
}
