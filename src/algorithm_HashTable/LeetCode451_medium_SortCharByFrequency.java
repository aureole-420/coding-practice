package algorithm_HashTable;

import java.util.*;
import java.util.Map.Entry;

// 1. 用treemap? treemap 还是不能按照value排序啊
// 老老实实写two phase， 先用hashmap统计次数，再用sort把次数sort一遍。
// O(klogk), k is the number of different chars.


// 看了答案，这题又是桶排序！！！
// 桶排序利用函数的映射关系，减少了几乎所有的比较工作 --- 桶排序就是映射，不是排序！！！
// bucket sort O(n)!!!!! 好题
public class LeetCode451_medium_SortCharByFrequency {
	
    public String frequencySort(String s) {
        	HashMap<Character, Integer> frequency = new HashMap<>();
        	for (char c : s.toCharArray()) {
        		frequency.put(c, frequency.getOrDefault(c, 0)+1);
        	}

        	
//        	List<Map.Entry<Character, Integer>> list = new ArrayList<>();
//        	for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
//        		list.add(entry);
//        	}
//        	
//        	Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
//				@Override
//				public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
//					return o2.getValue() - o1.getValue();
//				}      		
//        	});
//        	
//        	StringBuilder sb = new StringBuilder();
//        	for (Map.Entry<Character, Integer> entry : list) {
//        		for (int i = 0; i < entry.getValue(); i++) {
//        			sb.append(entry.getKey());
//        		}
//        	}
//        	
//        	return sb.toString();     
        	
        	
        	// in the following, use bucket sort!!!!!
        ArrayList<Character>[] buckets = (ArrayList<Character>[]) new ArrayList[s.length()+1];
        
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
        		char c = entry.getKey();
        		int count = entry.getValue(); // count in [0, s.length())
        		if (buckets[count] == null) {
        			buckets[count] = new ArrayList<Character>();
        		}
        		buckets[count].add(c);
        }
        
    StringBuilder sb = new StringBuilder();
    	for (int i = buckets.length-1; i>=0; i--) {
    		if (buckets[i] != null ) {
                while (buckets[i].size() != 0) {
                    char c = buckets[i].remove(0);
    			    for (int j = 0; j < i; j++) {
    				    sb.append(c);
    			    }
                }

    		}
    	}
    	
    	return sb.toString();       
        
    }
}
