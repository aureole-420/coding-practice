package algorithm_HashTable;
import java.util.*;


// 做前：题目有点怪，不用shift吗？
// 做后，注意要把string转化成lowerCase才行。
public class LeetCode500_easy_KeyboardRow {
	 public String[] findWords(String[] words) {
	    	
 		String[] strs = new String[] {"qwertyuiop","asdfghjkl","zxcvbnm"};
 		HashMap<Character, Integer> map = new HashMap<>();
 		for (int idx = 0; idx < strs.length; idx++) {    			
 			for (char c : strs[idx].toCharArray()) {
 				map.put(c, idx);
 			}
 		}
 		
 		List<String> res = new ArrayList<>();
 		for (String word : words) {

 			if (word.length() == 0) {
 				continue;
 			}
 			
 			int index = map.get(word.toLowerCase().charAt(0));
 			boolean inSameRow = true;
 			for (char c : word.toLowerCase().toCharArray()) {
 				if (map.get(c) != index) {
 					inSameRow = false;
 					break;
 				}
 			}
 			
 			if (inSameRow) {
 				res.add(word);
 			}
 		}
 		
 		return res.toArray(new String[0]);
 }
}
