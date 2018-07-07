package algorithm_HashTable;

import java.util.*;

public class LeetCode771_easy_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
    	
    		// corner case: 
    		if (J == null || S == null) {
    			return 0;
    		}
    		
        HashSet<Character> jewels = new HashSet<>();
        
        for (char c : J.toCharArray()) {
        		jewels.add(c);
        }
        
        int count = 0;
        for (char c : S.toCharArray()) {
        		if (jewels.contains(c)) {
        			count++;
        		}
        }
        
        return count;
    }
}
