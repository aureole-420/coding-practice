package algorithm_bfs_dfs;

// 解法很类似num of islands
// 做后： 值得一看！这题如果oldColor == newColor, 不依靠visited矩阵是很难解决的！
public class LeetCode733_easy_FloodFill {
	
	int[] dx = new int[] {1, -1, 0, 0};
	int[] dy = new int[] {0, 0, 1, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // corner case 
    		if (image == null || image.length == 0 || image[0].length == 0) {
    			return image;
    		}
    		
    		if (!inFigure(image, sr, sc)) {
    			return image;
    		}
    		
    		boolean[][] visited = new boolean[image.length][image[0].length];
    		
    		int oldColor = image[sr][sc];
    		dfs(image, visited, sr, sc, oldColor, newColor);
    		
    		return image;
    }
    
    private void dfs(int[][] image, boolean[][] visited, int sr, int sc, int oldColor, int newColor) {
//    		System.out.println("sr, sc: " + sr + " " + sc );
    		if (!inFigure(image, sr, sc) || visited[sr][sc] || image[sr][sc] != oldColor) {
    			return;
    		}
    		
    		image[sr][sc] = newColor;
    		visited[sr][sc] = true;
    		
    		for (int k = 0; k < dx.length; k++) {
    			int i = sr + dx[k];
    			int j = sc + dy[k];
    			dfs(image, visited, i, j, oldColor, newColor);
    		}
    }
    
    
    private boolean inFigure(int[][] image, int i, int j) {
    		if (i < 0 || j < 0 || i >= image.length || j >= image[0].length) {
    			return false;
    		}
    		return true;
    }
    
    public static void main(String[] args) {
    		int[][] mat = new int[][] {{0,0,0},{0,1,1}};
    		LeetCode733_easy_FloodFill ff = new LeetCode733_easy_FloodFill();
    		ff.floodFill(mat, 1, 1, 1);
    }
}
