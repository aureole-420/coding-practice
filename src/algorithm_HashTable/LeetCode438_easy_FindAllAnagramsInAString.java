package algorithm_HashTable;
import java.util.*;

// 做前：虽然我会做，1. 但我尝试用arr map来做 2. 我的做法是每次window size不变，start end 都move forward， 检查window
// 我的检查window方法效率太低，pattern中有k类元素，我就得把k比较一遍。

// 做中： 看了答案，用arr map来做的看不懂，写的不是人话。 用hashmap做的可以懂。
// 用一个counter来做window的检查。counter的每一个1都代表一类元素数量是否被window满足。
// 当window 满足条件时，counter == 0
// 每次移动end, 满足条件的情况下移动start
public class LeetCode438_easy_FindAllAnagramsInAString {
	
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : p.toCharArray()) {
        		map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int begin = 0, end = 0;
        int counter = map.size();
        
        while (end < s.length()) {
        		char c = s.charAt(end);
        		if (map.containsKey(c)) {
        			map.put(c, map.get(c)-1);
        			if (map.get(c) == 0) counter--;
        		}
        		end++;
        		
        		while (counter==0) { // counter == 0 说明所有的map.get(c) == 0
        			if (end-begin == p.length()) {
        				result.add(begin);
        			}
        			
        			char tempc = s.charAt(begin);
        			if (map.containsKey(tempc)) {
        				map.put(tempc, map.get(tempc)+1);
        				if (map.get(tempc) > 0) {
        					counter++;
        				}
        			}
        			begin++;
        		}
        } 
        
        return result;
    }
}
