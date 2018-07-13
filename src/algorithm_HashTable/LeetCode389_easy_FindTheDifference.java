package algorithm_HashTable;

// 做前：想到了用arr表示的map
public class LeetCode389_easy_FindTheDifference {
	
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
        		map[c-'a']++;
        }
        
        for (char c : t.toCharArray()) {
        		map[c-'a']--;
        		if (map[c-'a'] < 0) {
        			return c;
        		}
        }
        
        return 'a';
    }
}
