package algorithm_dp;

// f[i]: min Cost to the ith step
// init: f[0] = 0, f[1] = 0
// transition function: f[i] = min(f[i-1] + cost[i-1], f[i-2] + cost[i-2])
// ans: min(f[n-1], f[n-2])
public class LeetCode746_easy_MinCostClimbingStairs {
	
    public int minCostClimbingStairs(int[] cost) {
    	if (cost.length < 2) {
    		return 0;
    	}
    	
        int[] f = new int[cost.length+1];
        f[0] = 0;
        f[1] = 0;
        
        for (int i = 2; i <= cost.length; i++) {
        	f[i] = Math.min(f[i-1] + cost[i-1], f[i-2] + cost[i-2]);
        }
        
        return f[cost.length];
    }
}
