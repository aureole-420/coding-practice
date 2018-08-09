package algorithm_dp;

// 简单的dp，
// 从左向右 paint
// dp[i][j], paint 第i个house为 color j的min cost
// dp[i][j] = MIN(dp[i-1][k]) + cost[i][j], k != j
public class LeetCode256_easy_PaintHouse {
	
    public int minCost(int[][] costs) {
    	
    	// corner case
    	if (costs == null || costs.length == 0) {
    		return 0;
    	}
        int N = costs.length; // # of houses
        int C = costs[0].length; // # of colors
        
        int[][] dp = new int[N][C];
        
        // init
        for (int j = 0; j < C; j++) {
        	dp[0][j] = costs[0][j];
        }
        
        // transition
        for (int i = 1; i < N; i++) {
        	for (int j = 0; j < C; j++) {
        		
        		int minCost = Integer.MAX_VALUE;
        		for (int k = 0; k < C; k++) {
        			if (k != j) { // previous house color different from current one
        				int curCost = costs[i][j] + dp[i-1][k];
        				minCost = Math.min(minCost, curCost);
        			}
        		}
        		dp[i][j] = minCost;
        	}
        }
        
        // ans
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < C; j++) {
        	ans = Math.min(ans, dp[N-1][j]);
        }
        return ans;
    }
}
