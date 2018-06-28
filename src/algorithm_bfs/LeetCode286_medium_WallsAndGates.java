package algorithm_bfs;
import java.util.*;


// 做前，想得比较多，想得是multi source shortest path
// 构建一个pq, 然后类似于build shortest path tree，每次从pq中dequeue的点被加入SPT


// 做中： 看了一下答案，第二种解法太屌了！多个source 同时开始bfs，保证每个点只被visit一次
// https://leetcode.com/problems/walls-and-gates/solution/
public class LeetCode286_medium_WallsAndGates {
	
	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int GATE = 0;
	
	int[] dx = new int[] {1, -1, 0 , 0};
	int[] dy = new int[] {0, 0, 1, -1};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rooms.length; r++) {
        		for (int c = 0; c < rooms[0].length; c++) {
        			if (rooms[r][c] == GATE) {
        				queue.offer(new int[] {r,c});
        			}
        		}
        }
        
        while (!queue.isEmpty()) {
        		int[] cur = queue.poll();
        		int r0 = cur[0], c0 = cur[1];
        		
        		for (int k = 0; k < dx.length; k++) {
        			int r = r0 + dx[k], c = c0+dy[k];
        			if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] != EMPTY) {
        				continue;
        			}
        			rooms[r][c] = 1 + rooms[r0][c0];
        			queue.offer(new int[] {r, c});
        		}
        }
            
    }
}
