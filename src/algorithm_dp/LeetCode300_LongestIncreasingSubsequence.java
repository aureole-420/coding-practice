package algorithm_dp;


// states: f[i] the len of LIS up to i chars, and end with s[i], i = 0, 1, ...., N-1
// init: f[i] = 1
// function: f[i] = MAX{f[j]+1}, j < i && s[j] <= s[i]
// return f[N-1
public class LeetCode300_LongestIncreasingSubsequence {
	
    public int lengthOfLIS(int[] nums) {
    	// corner case;
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	
        int N = nums.length;
        
        //states: 
        int[] f = new int[N];
        
        // init:
        for (int i = 0; i < N; i++) {
        	f[i] = 1;
        }
        
        // transfer
        for (int i = 1; i < N; i++) {
        	int max = f[i];
        	for (int j = 0; j < i; j++) {
        		if (nums[j] < nums[i]) {
        			max = Math.max(max, f[j]+1);
        		}
        	}
        	f[i] = max;
        }
        
        // result
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
        	maxLen = Math.max(maxLen, f[i]);
        }
        
        return maxLen;
    }
}
