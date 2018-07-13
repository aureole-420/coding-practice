package algorithm_HashTable;
import java.util.*;

// 做前： 这题一看到window就觉得可以用 two pointers； 用hashmap记录window内的满足条件char的数量。
// use two pointers, start and end; [start, ...., end)
// if map.size() < set.length(), end++
// if map.size() == set.length(), start--;
// 思考一下，关键是第i个字符结尾的substring中满足条件的最短的string 被找到后我们就扫搜第i+1个字符结尾的substring中满足条件的最短string

// 做中： 我真特么服了出题人：
//Input:
//"aa"
//"aa"
//Output:
//"a"
//Expected:
//"aa"

// 还特么能重复，简单解法就是把set改成map

// 做后：看了一下跑的快的那些结果，发现用arr表示hashmap真的很快。我用java.util.hashmap 76ms, arr 4ms
// 主要是用arr的加减，而不是hashmap的getkey比较
public class LeetCode76_hard_MinWindowSubstring {
    public String minWindow(String s, String t) {
    	 	// corner case
    		if (s == null || t == null || t.length() == 0 || t.length() > s.length()) {
    			return "";
    		}
    	
        HashMap<Character, Integer> requiredChars = new HashMap<>();
        for (char c : t.toCharArray()) {
        		requiredChars.put(c, requiredChars.getOrDefault(c, 0)+1);
        }
        
        HashMap<Character, Integer> containedChars = new HashMap<>();
        
        // e.g. S = "ADOBECODEBANC", T = "ABC"
        int start = 0, end = 0;
        int bestStart = -1, bestEnd = -1;
        int minWinLen = Integer.MAX_VALUE;
        while (true) {
        		if (end == s.length()) { // end pointer cannot move forward anymore
        			if (!isQualified(requiredChars, containedChars)) { // map.size() < 3, no more qualified substrings
        				break; //直到最后第n-1个字母结尾地substring都被搜索完后才break
        			} else { // map.size() == 3, record and shrink the string
        				int curWinLen = end-start+1;
        				if (curWinLen < minWinLen) {
        					minWinLen = curWinLen;
        					bestStart = start; bestEnd =end;
        				}
        				
        				removeChar(s.charAt(start), requiredChars, containedChars);
        				start++;
        			}
        		} else { // both start and end can move forward
        			if (isQualified(requiredChars, containedChars)) { // map.size() == 3, record and shrink the string
        				int curWinLen = end-start+1;
        				if (curWinLen < minWinLen) {
        					minWinLen = curWinLen;
        					bestStart = start; bestEnd =end;
        				}
        				
        				removeChar(s.charAt(start), requiredChars, containedChars);
        				start++;
        			} else { // map.size() < 3, need to push forward
        				addChar(s.charAt(end), requiredChars, containedChars);
        				end++;
        			}
        		}    		
        }
        
        if (bestStart < 0) { // no qualified window found;
        		return "";
        } else {
        		return s.substring(bestStart, bestEnd);
        }
        
    }
    
    private boolean isQualified(HashMap<Character, Integer> requiredChars, HashMap<Character, Integer> containedChars) {
    		for (char c : requiredChars.keySet()) {
    			if (!containedChars.containsKey(c)) {
    				return false;
    			} 
    			if (containedChars.get(c) < requiredChars.get(c)) {
    				return false;
    			}
    		}
    		
    		return true;
    }
    
    private void addChar(char c, HashMap<Character, Integer> requiredChars, HashMap<Character, Integer> containedChars) {
    		if (!requiredChars.containsKey(c)) {
    			return;
    		}
    		
    		containedChars.put(c, containedChars.getOrDefault(c, 0)+1);
    }
    
    private void removeChar(char c, HashMap<Character, Integer> requiredChars, HashMap<Character, Integer> containedChars) {
		if (!requiredChars.containsKey(c)) {
			return;
		}
		
		if (containedChars.get(c) == 1) {
			containedChars.remove(c);
		} else {
			containedChars.put(c, containedChars.get(c)-1);
		}
    }	
    
}
