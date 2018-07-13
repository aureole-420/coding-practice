package algorithm_HashTable;
import java.util.*;

// 这题跟205 isomorphic string 如出一辙，都是一一映射(bijection), 需要双向检验。
// bijection: A<->B : (1) A->B (2) A<-B
// 做后： 几个坑： 1. split("\\s+") not split("//s+")
// 2.25行比较两个string是a.equals(b),不是a == b

// word pattern II用backtracking做！
public class LeetCode290_easy_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] words = str.split("\\s+");
        
        if (chars.length != words.length) {
        		return false;
        }
        
        // phase I: char -> word
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
        		char c = chars[i];
        		String word = words[i];
        		if (!map.containsKey(c)) {
        			map.put(c, word);
        		} else {
//        			if (map.get(c) != word) {
        			if (!map.get(c).equals(word)) {
        				return false;
        			}
        		}  		
        }
        
        // phase II: word -> char
        HashMap<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {    		
        		String word = words[i];
        		char c = chars[i];
        		if (!map2.containsKey(word)) {
        			map2.put(word, c);
        		} else {
        			if (map2.get(word) != c) {
        				return false;
        			}
        		}  		
        }
        
        return true;
    }
}
