package algorithm_dp;

// sequence dps
// f[i]: num of ways til the i^th
// init: f[0], f[1]
// transition function: i-2, i-1, i,
// （1）如果i-1， i构成了 valid number，那么f[i] = f[i-2] 
//      (1.1) 如果 i的数字合法：f[i] += f[i-1];
//  (2) otherwise, f[i] = f[i-1] e.g. 2,7
public class LeetCode91_medium_DecodeWays {
	
    public int numDecodings(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	
        char[] arr = s.toCharArray();
        
        // states: f[i], first i numbers
        int[] f = new int[arr.length + 1];
        
        // init:
        f[0] = 1;
        
        if (isValid(new char[] {arr[0]})) {
        	f[1] = 1;
        } else {
        	f[1] = 0;
        }
        
        if (arr.length == 1) {
        	return f[1];
        }
        
        // transition function:
        for (int i= 2; i <= arr.length; i++) {
        	if (isValid(new char[] {arr[i-2], arr[i-1]})) {
        		f[i] = f[i-2];
        		if (isValid(new char[] {arr[i-1]})) {
        			f[i] += f[i-1];
        		}
        	} 
        	else { // otherwise
        		if (isValid(new char[] {arr[i-1]})) {
        			f[i] = f[i-1];
        		} else { // impossible to decode the string into numbers, e.g. 17 0
        			return 0;
        		}
        		
        	}	
        }
        
        return f[arr.length];
    }
    
    // arr.length == 1 or 2
    private boolean isValid(char[] arr) {
    	if (arr.length == 1) {
    		if (arr[0] == '0') {
    			return false;
    		}
    		return true;
    	}
    	
    	// length = 2;
    	if (arr[0] == '0') {
    		return false;
    	}
    	String s = new String(arr);
    	int n = Integer.parseInt(s);
    	if (n <= 26 && n >= 1) {
    		return true;
    	}
    	return false;
    }
}
