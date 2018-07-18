package algorithm_dp;

// 相比62 unique paths， 只需要把obstacle set 成0就可以了
public class LeetCode63_medium_UniquePaths_II {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        // states
        int[][] f = new int[m][n];
        
        // initialization
        for (int i = 0; i < m; i++) {
        	if (obstacleGrid[i][0] == 1) {
        		break;
        	}
        	f[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++) {
        	if (obstacleGrid[0][j] == 1) {
        		break;
        	}
        	f[0][j] = 1;
        }
        
        // function:
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (obstacleGrid[i][j] == 1) {
        			continue;
        		}
        		f[i][j] = f[i-1][j] + f[i][j-1];
        	}
        }
        
        return f[m-1][n-1];
    }
}
