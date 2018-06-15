
package algorithm_bfs_dfs;
import java.util.*;

// https://leetcode.com/problems/01-matrix/description/
// https://leetcode.com/problems/01-matrix/solution/
// Google 面试题，实在是太好了
// 三种思路
// 1. brutal force，单点寻找最小值
// 2. 从0点出发bfs，不断更新最小值
// 3. DP
public class LeetCode542_medium_01Matrix {
	
	int[] dx = new int[] {1, -1, 0, 0};
	int[] dy = new int[] {0, 0, 1, -1};
    public int[][] updateMatrix(int[][] matrix) {
    		int NRow = matrix.length;
    		int NCol = matrix[0].length;
    		int[][] dist = new int[NRow][NCol];
    		
    		Queue<int[]> queue = new LinkedList<>();
    		
    		for (int i = 0; i < NRow; i++) {
    			for (int j = 0; j < NCol; j++) {
    				if (matrix[i][j] == 0) {
    					dist[i][j] = 0;
    					queue.offer(new int[] {i, j}); // push all 0 into queu
    				} else {
    					dist[i][j] = Integer.MAX_VALUE;
    				}	
    			}
    		}
    		
    		while (!queue.isEmpty()) {
    			int[] cur = queue.poll();
    			int i = cur[0], j = cur[1];
    			for (int k = 0; k < dx.length; k++) { // bfs
    				int ii = i + dx[k], jj = j + dy[k];
    				if (ii >= 0 && jj >= 0 && ii < NRow && jj < NCol) {
    					if (dist[ii][jj] > dist[i][j] + 1) {
    						dist[ii][jj] = dist[i][j] + 1;
    						queue.offer(new int[] {ii, jj}); // note that only updated points need to be enqueued.
    					}
    				}
    			}
    		}
    		
    		return dist;
    }
}
