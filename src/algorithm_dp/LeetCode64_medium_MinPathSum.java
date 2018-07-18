package algorithm_dp;

// 典型的matrix dp
// 1. fxy, 表示到x,y点的minpath sum
// 2. init, left / top boundary
// 3. function f(x, y) = min(f(x-1, y), f(x, y-1)) + A(x,y)
// 4. result: f(m-1, n-1)
public class LeetCode64_medium_MinPathSum {
	
    public int minPathSum(int[][] grid) {
    	
    	int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        	
        // initialization
        int sum = 0;
        for (int i = 0; i < m; i++) {
        	sum += grid[i][0];
        	f[i][0] = sum;
        }
        sum = 0;
        for (int j = 1; j < n; j++) {
        	f[0][j] = f[0][j-1] + grid[0][j];
        }
        
        // function:
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
        	}
        }
        
        // result
        return f[m-1][n-1];
    }
}
