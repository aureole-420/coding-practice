package algorithm_bfs_dfs;

import java.util.*;
import java.lang.*;
import java.io.*;

//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
// https://practice.geeksforgeeks.org/problems/x-total-shapes/0
public class GeeksforGeeks_BFSforAGraph {
	
	int[] dx = new int[] {1, -1, 0, 0};
	int[] dy = new int[] {0, 0, 1, -1};
	public int bfs(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int cnt = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'X') {
					bfs(grid, i, j);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	private void bfs(char[][] grid, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int ii = cur[0];
			int jj = cur[1];
			grid[ii][jj] = 'O';
			
			for ( int k = 0; k < dx.length; k++) {
				int iii = ii + dx[k];
				int jjj = jj + dy[k];
				if (inGrid(grid, iii, jjj)) {
					if (grid[iii][jjj] == 'X') {
						queue.offer(new int[] {iii, jjj});	
					}
				}
			}
		}
		
		return;
	}
	
	private boolean inGrid(char[][] grid, int i, int j) {
		if ( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
			return true;
		}
		return false;
	}
	
	public static void main (String[] args) {
		GeeksforGeeks_BFSforAGraph gfg = new GeeksforGeeks_BFSforAGraph();
		
		Scanner sc = new Scanner(System.in);
		int numOfTestCase = sc.nextInt();
		
		for (int n = 0; n < numOfTestCase; n++) {
			int numRows = sc.nextInt();
			int numCols = sc.nextInt();
			System.out.println("num of rows and cols" + numRows + " " + numCols);
			
			char[][] grid = new char[numRows][numCols];
			sc.nextLine();
			String gridString = sc.nextLine();
			System.out.println(gridString);
			String[] tokens = gridString.split("\\s+");
			
			for (int i = 0; i < numRows; i++) {
				char[] row = tokens[i].toCharArray();
				System.out.println(tokens[i]);
				for (int j = 0; j < numCols; j++) {
					System.out.println("dealing with entry: (" + i + "," + j + ")");
					grid[i][j] = row[j];
				}
			}
			
			int res = gfg.bfs(grid);
			System.out.println(res);
		}
	}
}
