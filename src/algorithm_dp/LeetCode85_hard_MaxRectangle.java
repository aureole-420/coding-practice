package algorithm_dp;

import java.util.Arrays;

// 做前：
// sequence dp
// 用两个sequence来存，子问题是高和宽
// state： W[i][j], H[i][j]， width and height of rectangle ended with mat[i][j] as right bottom corner.
// init: if ...
// transfer function: if mat[i][j] == '1':  W[i][j] = W[i][j-1] + 1
//                							H[i][j] = H[i-1][j] + 1
// answer: MAX{W[i][j] * H[i][j]}

// 做后：
// 思路其实有点对，但是
public class LeetCode85_hard_MaxRectangle {
	
	// 看了答案
	// maintain leftBoundary, rightBoundary (exclusive), height 三个矩阵
	// left(i,j) = max(left(i-1, j), curleft)
	// right(i,j) = min(right(i-1, j), curRight)
	// e.g. 
//	0 0 0 1 0 0 0 
//	0 0 1 1 1 0 0 
//	0 1 1 1 1 1 0
//	The vector "left" and "right" from row 0 to row 2 are as follows
//
//	row 0:
//
//	l: 0 0 0 3 0 0 0
//	r: 7 7 7 4 7 7 7
//	row 1:
//
//	l: 0 0 2 3 2 0 0
//	r: 7 7 5 4 5 7 7 
//	row 2:
//
//	l: 0 1 2 3 2 1 0
//	r: 7 6 5 4 5 6 7
	public int maximalRectangle(char[][] matrix) {
		// corner case:
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[] left = new int[n]; int[] right = new int[n]; int[] height = new int[n];
		Arrays.fill(right, n);
		int maxArea = 0;
		
		//  scan row by row 
		for (int i = 0; i < m; i++) {
			int curLeft = 0, curRight = n;
			
			// compute height;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}
			
			// compute left boundary
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], curLeft);
				} else {
					left[j] = 0; // height = 0, 也就是下一层与这一层无关。
					curLeft = j+1;
				}
			}
			
			// compute right boundary
			for (int j = n-1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], curRight);
				} else {
					right[j] = n; // 这个是0，重制right[j],不影响下一层。
					curRight = j; // 0的点是这一层的cur右边界
				}
			}
			
			// compute area
			for (int j = 0; j < n; j++) {
				maxArea = Math.max(maxArea, (right[j]-left[j]) * height[j]);
			}
		}
			
		return maxArea;
	}
//	
//    public int maximalRectangle(char[][] matrix) {
//        int N = matrix.length, M = matrix[0].length;
//        
//        // state:
//        int[][] W = new int[N+1][M+1];
//        int[][] H = new int[N+1][M+1];
//        
//        // init
//        
//        // transfer function:
//        int res = Integer.MIN_VALUE;
//        for (int i = 1; i <= N; i++) {
//        	for (int j = 1; j <= M; j++) {
//        		int curArea = 0;
//        		if (matrix[i-1][j-1] == '1') {
//        			int WL = W[i][j-1], WU = W[i-1][j];
//        			int HL = H[i][j-1], HU = H[i-1][j];
//        			int leftBoundary = Math.min(Math.max(j-1- WL, j-WU), j-1);
//        			W[i][j] = j - leftBoundary;
//        			int UpperBoundary = Math.min(Math.max(i-1-HU, i-HL), i-1);
//        			H[i][j] = i - UpperBoundary;
//        			curArea = W[i][j] * H[i][j];
//            		if ( i == 2 && j == 1) {
//            			System.out.println(WL+" " + HL + " " + WU +" " + HU);
//            			System.out.println("("+i+","+j+"):"+W[i][j]+" " + H[i][j] + " area: " + curArea);
//            		}
//        		}
//        		res = Math.max(curArea, res);
//        		System.out.println("("+i+","+j+"):"+W[i][j]+" " + H[i][j] + " area: " + curArea);
//
//        		
//        	}
//        }
//        
//        // ans:
//        return res;
//    }
    
    public static void main(String[] args) {
    	char[][] mat = new char[][] {{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'}, {'1','0','0','1','0'} };
    	LeetCode85_hard_MaxRectangle mr = new LeetCode85_hard_MaxRectangle();
    	mr.maximalRectangle(mat);
    }
}
