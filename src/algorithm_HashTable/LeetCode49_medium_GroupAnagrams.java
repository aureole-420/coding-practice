package algorithm_HashTable;
import java.util.*;


// 我想到的是generate key，不需要比较
public class LeetCode49_medium_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    		List<List<String>> result = new LinkedList<>();
    		
    		
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
        		String key = generateKey(str);
        		System.out.println(key);
        		if (!map.containsKey(key)) {
        			map.put(key, new LinkedList<String>());
        		}
        		map.get(key).add(str);
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        		result.add(entry.getValue());
        }
        
        return result;
    }
    
    private String generateKey(String word) {
    		HashMap<Character, Integer> map = new HashMap<>();
    		
    		for (char c : word.toCharArray()) {
    			map.put(c, map.getOrDefault(c, 0) + 1);
    		}
    		
    		List<Character> list = new ArrayList<>();
    		for (char c : map.keySet()) {
    			list.add(c);
    		}
    		
    		Collections.sort(list);
    		
    		// build key
    		StringBuilder sb = new StringBuilder();
    		for (char c : list) {
    			sb.append(c + Integer.toString(map.get(c)));
    		}
    		
    		return sb.toString();
    }
    
    public static void main(String[] args) {
    		String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
    		LeetCode49_medium_GroupAnagrams ga = new LeetCode49_medium_GroupAnagrams();
    		
    		ga.groupAnagrams(strs);
    		
    }
}
