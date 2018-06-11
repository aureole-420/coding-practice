package algorithm_bfs_dfs;

// https://leetcode.com/problems/surrounded-regions/description/
/**
 * 思路，从边缘开始处理？把所有不需要翻转的都表示出来
 *
 */
public class LeetCode130_medium_SurroundedRegions {
	
	   int[] dx = new int[] {1, -1, 0, 0};
	   int[] dy = new int[] {0, 0, 1, -1};
	   
	   public void solve(char[][] board) {
		   
		   // corner case
	        if (board == null || board.length == 0 || board[0].length == 0) {
	        		return;
	        }
	        
	        boolean[][] visited = new boolean[board.length][board[0].length];
	        boolean[][] noFlip = new boolean[board.length][board[0].length];
	        for (int i = 0; i < visited.length; i++) {
	        		for (int j = 0; j < visited[0].length; j++) {
	        			visited[i][j] = false;
	        			noFlip[i][j] = false;
	        		}
	        }
	        
	        // dfs boarder elements
	        int i, j;
	        for (i = 0, j = 0; j < board[0].length; j++) {
//	        		System.out.println(i + " " + j);
	        		dfs(board, visited, noFlip, i, j);
	        }
	        
	        for (i = board.length-1, j = 0; j < board[0].length; j++) {
//	        System.out.println(i + " " + j);
        		dfs(board, visited, noFlip, i, j);
        }
	        for (i = 0, j = 0; i < board.length; i++) {
//	        	System.out.println(i + " " + j);
        		dfs(board, visited, noFlip, i, j);
        }
	        for (i = 0, j = board[0].length-1; i < board.length; i++) {
//	        	System.out.println(i + " " + j);
        		dfs(board, visited, noFlip, i, j);
        }
	        
	        for (i = 0; i < visited.length; i++) {
        		for (j = 0; j < visited[0].length; j++) {
        			if (board[i][j] == 'O' && !noFlip[i][j]) {
        				board[i][j] = 'X';
        			}
        		}
        }
	        
	    }
	   
	   private void dfs(char[][] board, boolean[][] visited, boolean[][] noFlip, int i, int j) {
		   if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			   return;
		   }
		   
		   if (visited[i][j]) {
			   return;
		   }
		   
		   visited[i][j] = true;
		   
		   System.out.println("Visiting (" + i + " " + j + ") " + board[i][j]);
		   if (board[i][j] == 'O') {
			   noFlip[i][j] = true;
			   for (int k = 0; k < dx.length; k++) {
				   int ii = i + dx[k], jj = j + dy[k];
				   dfs(board, visited, noFlip, ii, jj);
			   } 
		   }
	   }
	   
	   public static void main(String[] args) {
		   char[][] mat = new char[4][4];
		   mat[0] = new char[] {'X','X','X','X'};
		   mat[1] = new char[] {'X','O','O','X'};
		   mat[2] = new char[] {'X','X','O','X'};
		   mat[3] = new char[] {'X','O','X','X'};
		   
		   LeetCode130_medium_SurroundedRegions sr = new LeetCode130_medium_SurroundedRegions();
		   sr.solve(mat);
 	   }
}
