package algorithm_graph_I;


import java.util.*;
/*
 * Leetcode 305
 */
public class NumberOfIslandsII {
	private int[] dx = new int[] {1, -1, 0, 0};
	private int[] dy = new int[] {0, 0, 1, -1};
	private int[] id; // position -> id : (x,y) -> x*n+y 
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    		List<Integer> res = new LinkedList<Integer>();
    		if (m == 0 || n == 0 || positions == null || positions.length == 0) 
    			return res;
    		
        id = new int[m*n];
        Arrays.fill(id, -1);
        int count = 0; // initially 0 islands
        for (int i = 0; i < positions.length; i++) {
        		int curX = positions[i][0];
        		int curY = positions[i][1];
        		int curId = curX*n + curY;
        		id[curId] = curId;
        		count++; // assume it is an island
        		for (int j = 0; j < dx.length; j++) {
        			int adjX = curX + dx[j];
        			int adjY = curY + dy[j];
        			int adjId = adjX*n + adjY; 
        			if (adjX < 0 || adjX >= n || adjY < 0 || adjY >= m || id[adjId] < 0) {
        				continue; // not valid adjacent nodes;
        			}
        			// otherwise check the father;
        			int curFather = findFather(curId);
        			int adjFather = findFather(adjId);
        			if (curFather != adjFather) {
        				id[curFather] = adjFather; // union
        				count--;
        			}
        		}
        		res.add(count);
        }
        return res;
    }
    
    // returns the boss of this point.
    private int findFather(int pointId) {
    		if (id[pointId] == pointId) 
    			return pointId;
    		else {
    			id[pointId] = findFather(id[pointId]);
    			return id[pointId]; // here is path compression;
    		}
    }
}
