package algorithm_ladder_II;

public class Redo_SmallestRectangleEnclosingBlackPixels {
	class ResultType {
		int wBound, eBound, nBound, sBound;
		ResultType(int w, int e, int n, int s) {
			wBound = w;
			eBound = e;
			nBound = n;
			sBound = s;
		}
	}
	
	int[] dx = new int[] {1, -1, 0, 0};
	int[] dy = new int[] {0, 0, 1, -1};
	
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // corner case:
    		if (image == null || image.length == 0 || image[0].length == 0) {
    			return 0;
    		}
    		
    		int m = image.length, n = image[0].length; // m rows, n columns
    		
    		// dfs search 
    		boolean[][] visited = new boolean[m][n];
    		for (int i = 0; i < m; i++) {
    			for (int j = 0; j < n; j++) {
    				visited[i][j] = false;
    			}
    		}
    		
    		ResultType rt = new ResultType(x, x, y, y);
    		
    		dfs(image, x, y, visited, rt);
    		
    		return (rt.eBound - rt.wBound + 1) * (rt.sBound - rt.nBound + 1);
    }
    
    private void dfs(char[][] image, int x, int y, boolean[][] visited, ResultType rt) {
    		System.out.println( "visiting point (" + x + ", " + y+ ")");
    		int m = image.length, n = image[0].length; // m rows, n columns
    		
    		// base case 1
    		if (!inRectangle(m,n, x, y) || image[x][y] == '0' || visited[x][y]) {
    			System.out.println("stopped");
    			return;
    		}
    		// base case 2: a new  black pixel
    		visited[x][y] = true;
    		if (y > rt.eBound) {rt.eBound = y; System.out.println("e triggered");}
    		if (y < rt.wBound) {rt.wBound = y; System.out.println("w triggered");}
    		if (x < rt.nBound) {rt.nBound = x; System.out.println("n triggered");}
    		if (x > rt.sBound) {rt.sBound = x; System.out.println("s triggered");}
    		
    		for (int i = 0; i < dx.length; i++) {
    			int newX = x + dx[i];
    			int newY = y + dy[i];
    			dfs(image, newX, newY, visited, rt);
    		}
    }
    
    private boolean inRectangle(int m, int n, int newX, int newY) {
    		if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
    			return false;
    		} else {
    			return true;
    		}
    }
	
	public static void main(String[] args) {
		char[][] A = new char[3][4];
		A[0] = new char[] {'0','0','1','0'};
		A[1] = new char[] {'0','1','1','0'};
		A[2] = new char[] {'0','1','0','0'};
		Redo_SmallestRectangleEnclosingBlackPixels s = new Redo_SmallestRectangleEnclosingBlackPixels();
		System.out.println(s.minArea(A, 1, 2));
	}
}
