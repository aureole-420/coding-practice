package algorithm_dp;

// 看到这题就觉得跟range sum query很像，仍然可以用presum来做
// preSum(i, j) =  mat(i,j) + preSum(i-1, j) + preSum(i, j-1) - preSum(i-1, j-1)
// then
// sumRegion(r1, c1, r2, c2) = preSum(r2, c2) - preSum(r2, c1-1) - preSum(r1-1, c2) + preSum(r1-1, r2-1)
public class LeetCode304_medium_RangeSumQuery2D_Immutable {
	
	int[][] preSum = null;
    public void NumMatrix(int[][] matrix) {
    	if (matrix == null || matrix.length == 0) {
    		return;
    	}
        int N = matrix.length, M = matrix[0].length;
        preSum = new int[N+1][M+1];
        // init: presum[0][0...M] = presum[0...N][0] = 0
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= M; j++) {
        		preSum[i][j] = matrix[i-1][j-1] + preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1];
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (preSum == null) {
    		return 0;
    	}
    	int r1 = row1+1, c1 = col1+1, r2 = row2+1, c2 = col2+1;
        return preSum[r2][c2] - preSum[r2][c1-1] - preSum[r1-1][c2] + preSum[r1-1][c1-1];
    }
}
