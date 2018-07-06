package algorithm_twoPointers;
import java.util.*;

// 这题我的想法不错，做完后发现跟标答差不多的结果， O(n)
// 类似题目有：
// 340. Longest Substring with At Most K Distinct Characters
// 3. Longest Substring Without Repeating Characters
public class LeetCode159_hard_LongestSubstringWithAtMost2DistinctChar {
	
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    		// corner case
    		if (s == null || s.length() == 0) {
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
        				if (map.size() > 2) {
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
