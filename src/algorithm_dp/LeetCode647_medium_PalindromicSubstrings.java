package algorithm_dp;

// 不会做，直接看答案：
// 如果用简单的check，O(n^3)
// 用中心拓展的方式：
public class LeetCode647_medium_PalindromicSubstrings {
	
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        char[] arr = s.toCharArray();
        
        int count = 0;
      
        for (int center = 0; center < 2*arr.length-1; center++) {
        	
        	// check centered at i && (i, i+1)  -- 偶数palindrome有两个center
        	int j = center / 2;
        	int k = j + center % 2;
        	
        	while (j >= 0 && j < arr.length && k >= 0 && k < arr.length) {
        		if (arr[j] == arr[k]) {
        			count++;
        			j--;
        			k++;
        		} else {
        			break;
        		}
        	}
        	
        	// check centered at i, i+1
        }
        
        return count;
    }
    
}
