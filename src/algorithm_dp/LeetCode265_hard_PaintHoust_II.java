package algorithm_dp;
//这题基本跟paint house I 一模一样，
// 区别： 要求 O(kr)
// 我现在的O(kr^2)
// 
// 实现：
// 实际上没有必要有第三层循环，
//因为第三层循环做的是找前一个house的最小 cost
// 可以maintain两组常数， prevMinCost (& associate Color), prevSecMinCost (& associate Color)
// if possible,用 prevMinCost, otherwise, use prevSecMinCost
public class LeetCode265_hard_PaintHoust_II {
	  public int minCostII(int[][] costs) {
	    	
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
