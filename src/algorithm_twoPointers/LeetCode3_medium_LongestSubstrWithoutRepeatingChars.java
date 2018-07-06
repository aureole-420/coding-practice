package algorithm_twoPointers;
import java.util.*;

// 因为做了类似题：157/340 才做这一题
// debug了半天，因为21行写成了start > 1

public class LeetCode3_medium_LongestSubstrWithoutRepeatingChars {
	public int lengthOfLongestSubstring(String s) {
        // corner case
    		if (s == null || s.length() == 0) {
    			return 0;
    		}
    		
    		int start = 0, end = 0;  // [start .... end] inclusive
    		int maxLen = 1;
    		HashSet<Character> set = new HashSet<>();
    		set.add(s.charAt(0));
    		
    		for (; start < s.length(); start++) {
    			
    			if (start > 0) { 
    				set.remove(s.charAt(start-1));
    			}
    			// find the end;
    			while (true) {
    				int potentialIdx = end+1;
    				System.out.println("start"+start+"::potentialIdx::"+potentialIdx+"::set.size()::"+set.size());
    				if (potentialIdx <  s.length()) {
    					char potentialChar = s.charAt(potentialIdx);
    					if (set.contains(potentialChar)) { // end found
    						// int curLen = end - start + 1;
    						// maxLen = Math.max(curLen, maxLen);
    						break;
    					} else { // push end forward
    						set.add(potentialChar);
    						end++;
    					}
    				} else { // reach the end
    					break;
    				}
    				
    			}
                System.out.println(start + "::" + end);
                maxLen = Math.max(maxLen, end-start+1);
    		}
    		
    		return maxLen; 		
    }
	
	public static void main(String[] args) {
		LeetCode3_medium_LongestSubstrWithoutRepeatingChars ls = new LeetCode3_medium_LongestSubstrWithoutRepeatingChars();
		
		ls.lengthOfLongestSubstring("aab");
	}
}
