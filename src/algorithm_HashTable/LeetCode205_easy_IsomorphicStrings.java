package algorithm_HashTable;
import java.util.*;

// 做前：挺简单的？一一检查就行了，出现重复映射就return false


// 做后，好题，第一次没通过。 错在少了一个phase，一一映射的条件是： 
// A->B && B->A
// two pass， 
// s,t中char一一对应：
// step1: 每一个cs只对应一个ct
// step2: 每一个ct只对应一个cs
public class LeetCode205_easy_IsomorphicStrings {
	

	
	// s and t are of same len
    public boolean isIsomorphic(String s, String t) {
    	
        
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        
        // 这里只排除了 不会有多个ct对应同一个cs，但有可能多个cs对应一个ct
        for (int i = 0; i < s.length(); i++) {
        		char cs = s.charAt(i);
        		char ct = t.charAt(i);
        		if (!map.containsKey(cs)) {
        			map.put(cs, ct);
        		} else {
        			if (map.get(cs) != ct) {
        				return false;
        			}
        		}        		
        }
        
        // 还需要检查ct 对应cs
        map.clear();
        for (int i = 0; i < s.length(); i++) {
    			char cs = s.charAt(i);
    			char ct = t.charAt(i);
    			if (!map.containsKey(ct)) {
    				map.put(ct, cs);
    			} else {
    				if (map.get(ct) != cs) {
    					return false;
    				}
    			}        		
        }
        
        
        return true;
              
    }
}
