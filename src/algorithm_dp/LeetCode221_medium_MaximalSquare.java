package algorithm_dp;

// 这题跟85 maximal rectangle 很像,更基本
// 核心在于， 
// 1. dp[i][j]: maxLen of square at mat[i][j]
// 2. dp[i][j] = min {dp[i-1][j],  dp[i][j-1], dp[i-1][j-1] } + 1
public class LeetCode221_medium_MaximalSquare {
	
    public int maximalSquare(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	}
    	
    	
        int N = matrix.length, M = matrix[0].length;
        int[][] dp = new int[N+1][M+1];
        int maxLen = 0;
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= M; j++) {
        		if (matrix[i-1][j-1] == '1') {
        			dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
        			maxLen = Math.max(maxLen, dp[i][j]);
        		}		
        	}
        }
        
        return maxLen * maxLen;
    }
}
