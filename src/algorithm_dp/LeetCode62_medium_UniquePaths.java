package algorithm_dp;

// classical matrix dp

// states: f[x][y] unique paths to points (x,y)
// initialization: top and left boundary
// functino: f[x][y] = f[x-1][y] + f[x][y-1]
public class LeetCode62_medium_UniquePaths {
    public int uniquePaths(int m, int n) {
    	// states
        int[][] f = new int[m][n];
        
        // initialization
        for (int i = 0; i < m;  i++) {
        	f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
        	f[0][j] = 1;
        }
        
        // function:
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		f[i][j] = f[i-1][j] + f[i][j-1];
        	}
        }
        
        return f[m-1][n-1];
    }
}
