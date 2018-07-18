package algorithm_HashTable;

import java.util.*;

// 做前： 第一步把word放到hashmap里面应该是没有异议的，但接下有效率比较高的吗？

// 做中： 这题关键是后面如何在两个有序列表中找到最小的distance ---- 两个有序线性结构 --- 当然是用two pointers啊！！！
// O(n) time complexity
public class LeetCode244_medium_ShortestWordDistance_II {
	
	private HashMap<String, List<Integer>> map = new HashMap<>();
    public void WordDistance(String[] words) {
    	for (int i = 0; i < words.length; i++) {
    		String word = words[i];
    		if (!map.containsKey(word)) {
    			map.put(word, new ArrayList<Integer>());
    		}
    		map.get(word).add(i);
    	}
        
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
        	int num1 = list1.get(i), num2 = list2.get(j);
        	if (num1 > num2) {
        		res = Math.min(res, num1 - num2);
        		j++;
        	} else {
        		res = Math.min(res,  num2 - num1);
        		i++;
        	}
        }
        
        return res;
    }
}
