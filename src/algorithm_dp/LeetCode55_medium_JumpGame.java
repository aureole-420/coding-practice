package algorithm_dp;

// 可以用greedy， 这里用了dp
// f[i]: 能否跳到第i个位置
// init: f[0] = true
// function: f[i] = OR(f[j], j < i && j 能够跳到i
// return： f[n-1]

// O(n^2) time complexity.
public class LeetCode55_medium_JumpGame {
	
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        
        // initialization
        f[0] = true;
        
        // function
        for (int i = 0; i < n; i++) {
        	if (!f[i]) {
        		continue;
        	}
        	for (int j = i+1; j < n && j <= i + nums[i]; j++) {
        		f[j] = true;
        	}
        }
        
        return f[n-1];
    }
}
