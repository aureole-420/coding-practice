package algorithm_dp;


// sequence dp
// 用两个sequence来存，子问题是高和宽
// state： W[i][j], H[i][j]， width and height of rectangle ended with mat[i][j] as right bottom corner.
// init: if ...
// transfer function: if mat[i][j] == '1':  W[i][j] = W[i][j-1] + 1
//                							H[i][j] = H[i-1][j] + 1
// answer: MAX{W[i][j] * H[i][j]}
public class LeetCode85_hard_MaxRectangle {
	
    public int maximalRectangle(char[][] matrix) {
        int N = matrix.length, M = matrix[0].length;
        
        // state:
        int[][] W = new int[N+1][M+1];
        int[][] H = new int[N+1][M+1];
        
        // init
        
        // transfer function:
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= M; j++) {
        		int curArea = 0;
        		if (matrix[i-1][j-1] == '1') {
        			int WL = W[i][j-1], WU = W[i-1][j];
        			int HL = H[i][j-1], HU = H[i-1][j];
        			int leftBoundary = Math.min(Math.max(j-1- WL, j-WU), j-1);
        			W[i][j] = j - leftBoundary;
        			int UpperBoundary = Math.min(Math.max(i-1-HU, i-HL), i-1);
        			H[i][j] = i - UpperBoundary;
        			curArea = W[i][j] * H[i][j];
        		}
        		res = Math.max(curArea, res);
        		System.out.println("("+i+","+j+"):"+W[i][j]+" " + H[i][j] + " area: " + curArea);
        	}
        }
        
        // ans:
        return res;
    }
    
    public static void main(String[] args) {
    	char[][] mat = new char[][] {{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'}, {'1','0','0','1','0'} };
    	LeetCode85_hard_MaxRectangle mr = new LeetCode85_hard_MaxRectangle();
    	mr.maximalRectangle(mat);
    }
}
