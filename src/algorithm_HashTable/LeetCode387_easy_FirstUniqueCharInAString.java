package algorithm_HashTable;

// 做前，只想到2 pass solution

// 做后，确实只有2 pass solution
// 不过可以用array 表示 hashmap，减少cost
public class LeetCode387_easy_FirstUniqueCharInAString {
	
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        
        for (char c : s.toCharArray()) {
        		count[c - 'a']++;
        }
        for (int idx = 0; idx < s.length(); idx++) {
        		if (count[s.charAt(idx) - 'a'] == 1) {
        			return idx;
        		}
        }
        
        return -1;
    }
    
}
