package algorithm_dp;


// 做前： 子问题是target从0，到 target
// dp[i] = sum(dp[j]) j < i && j + nums[k] = 
// transition
public class LeetCode377_medium_CombinationSum_IV {
	
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        
        // init 
        dp[0] = 1; // 不是0！！！
        
        // transition
        for (int i = 1; i <= target; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		if (i - nums[j] >= 0) {
        			dp[i] += dp[i-nums[j]];
        		}
        	}
        }
        
        return dp[target];
    }
    
}
