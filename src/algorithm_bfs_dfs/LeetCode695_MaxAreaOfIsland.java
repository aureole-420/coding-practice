package algorithm_bfs_dfs;

// https://leetcode.com/problems/max-area-of-island/description/
// 跟numof islands一样，可以在visited的时候就把grid设成0
// 免去了maintain一个visited 矩阵。
public class LeetCode695_MaxAreaOfIsland {
	
    public int maxAreaOfIsland(int[][] grid) {
    		// corner case
        if (grid == null || grid.length == 0) {
        		return 0;
        }
        	
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
        		for (int j = 0; j < grid[0].length; j++) {
        			int curArea = getArea(grid, i, j);
        			if (curArea > maxArea) {
        				maxArea = curArea; 
        			} 
        		}	
        }
        
        return maxArea;
    }
    
    
    // dfs to 
    private int getArea(int[][] grid, int i, int j) {
    		if (!inGrid(grid, i, j)) {
    			return 0;
    		}
    		if (grid[i][j] == 0) {
    			return 0;
    		}
    		
    		grid[i][j] = 0; // the point is visited
    		return 1 + getArea(grid, i+1, j) + getArea(grid, i-1, j) + getArea(grid, i, j+1) + getArea(grid, i, j-1);
    }
    
    private boolean inGrid(int[][] grid, int i, int j) {
    		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
    			return false;
    		}
    		return true;
    }
    
    private void testFunc(Integer ii) {
    		ii = ii + 1;
    }
    
    
    public static void main(String[] args) {
    		Integer ii = 10;
    		System.out.println(ii);
    		
    		LeetCode695_MaxAreaOfIsland mai = new LeetCode695_MaxAreaOfIsland();
    		mai.testFunc(ii);
    		System.out.println(ii);
    }
}
