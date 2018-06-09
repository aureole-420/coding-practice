package algorithm_graph_I;

// solution 1, using dfs
// O(V+E)
public class LeetCode200_NumberOfIslands {
	
	int[] dx = new int[] {1, -1, 0, 0};
	int[] dy = new int[] {0, 0, 1, -1};
	
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        		return 0;
        }
        
        int cnt = 0;
        
        for (int i = 0; i < grid.length; i++) {
        		for (int j = 0; j < grid[0].length; j++) {
        			if (grid[i][j] == '1') {
        				dfs(grid, i, j);
        				cnt++;
        			}
        		}
        }
        
        return cnt;
    }
    
    private void dfs(char[][] grid, int i, int j) {
    		if (!inGrid(grid, i, j)) {
    			return;
    		}
    		if (grid[i][j] == '0') {
    			return;
    		}
    		
    		grid[i][j] = '0';
    		for (int k = 0; k < dx.length; k++) {
    			int ii = i + dx[k];
    			int jj = j + dy[k];
    			if (inGrid(grid, ii, jj)) {
    				if (grid[ii][jj] == '1') {
    					dfs(grid, ii, jj);
    				}
    				
    			}
    		}
    }
    
    private boolean inGrid(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return false;
		} else {
			return true;
		}
    }
}
