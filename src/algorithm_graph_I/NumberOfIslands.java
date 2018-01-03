package algorithm_graph_I;

public class NumberOfIslands {
	/*
	 * 这题可以理解为森林找树的数量
	 * 笨的方法可以maintain一个visited矩阵。这个矩阵可以用在dfs中，也可以用在遍历所有点时判断是否还需要dfs。
	 * 比较巧的方法是在visit完一个点后就把这个点删掉（设为0），同时visit该点的所有neighbors。
	 * (1)这样dfs时无需判断点是否已经visit过
	 * (2) visit neighbour时也可以直接visit上下左右而不需要判断marked
	 */
	
	private char[][] grid;
	public int numIslands(char[][] grid) {
		this.grid = grid;
		if (grid == null || grid.length == 0) 
			return 0;
		
		int numOfIslands = 0;
		
		int N = grid.length;
		int M = grid[0].length;
		for (int i = 0; i < N; i++) {
    	   		for (int j = 0; j < M; j++) {
    	   			if (grid[i][j] == '1') {
    	   				dfs(i, j);
    	   				numOfIslands++;
    	   			}
    	   		}
		}
	   	return numOfIslands;
    }
	
	// dfs from node (i, j);
	private void dfs(int i, int j) {
		int N = grid.length;
		int M = grid[0].length;
		if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] == '0') {
			return;
		}
		
		grid[i][j] = '0';
		dfs(i+1, j);
		dfs(i-1, j);
		dfs(i, j+1);
		dfs(i, j-1);	
	}
}
