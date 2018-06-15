package algorithm_bfs_dfs;
import java.util.*;
// 好题，不太容易想到model
// 实际解法和number of islands类似
// 问题问的是grid coordinates connecting both Pacific and Atlantic Ocean
// 如果问题简化成是否connect to Pacific Ocean就好想了吧？很自联想到用dfs/bfs来做搜索。

// 这个问题就是拆分成两个子问题： 1. 是否和Pacific相连， 2. 是否和Atlantic Ocean相连。 
// 最后合到一起去就可以了。
// https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90733/Java-BFS-and-DFS-from-Ocean
// https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90749/JAVA-17ms-Solution-Simple-and-Clear-similar-to-Number-of-Islands's-idea
public class LeetCode417_medium_PacificAtlanticWaterFlow {
	
	int[] dx = new int[] {1, -1, 0, 0};
	int[] dy = new int[] {0, 0, 1, -1};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new LinkedList<int[]>();
        // corner case: 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        		return result;
        }
        
        int NRow = matrix.length, NCol = matrix[0].length;
        
        boolean[][] pacific = new boolean[NRow][NCol];
        boolean[][] atlantic = new boolean[NRow][NCol];
        
        for (int j = 0; j < NCol; j++) {
        		dfs(matrix, pacific, Integer.MIN_VALUE, 0, j);
        		dfs(matrix, atlantic, Integer.MIN_VALUE, NRow-1, j);
        }
        for (int i = 0; i < NRow; i++) {
        		dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
        		dfs(matrix, atlantic, Integer.MIN_VALUE, i, NCol-1);
        }
        
        for (int i = 0; i < NRow; i++) {
        		for (int j = 0; j < NCol; j++) {
        			if (pacific[i][j] && atlantic[i][j]) {
        				result.add(new int[] {i, j});
        			}
        		}     
        }
        
        return result;
        
    }
    
    // only visit the grid coordinates that connecting to ocean
    private void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j) {
    		int NRow = matrix.length, NCol = matrix[0].length;
    		if (i < 0 || i >= NRow || j < 0 || j >= NCol) {
    			return;
    		}
    		if (visited[i][j]) {
    			return;
    		}
    		
    		if (matrix[i][j] < height) {
    			return; // water cannot flow from this to prev
    		}
    		
    		// otherwise water can flow into prev:
    		visited[i][j] = true;
    		for (int k = 0; k < dx.length; k++) {
    			int ii = i + dx[k], jj = j + dy[k];
    			dfs(matrix, visited, matrix[i][j], ii, jj);
    		}
    }
}
