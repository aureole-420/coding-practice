package algorithm_ladder_II;

/**
 * leetcode 302
 *
 */
public class SmallestRectangleEnclosingBlackPixels {
	
	private char[][] A;
	public int minArea(char[][] A, int x, int y) {
		this.A = A;
		int m = A.length; // numRows
		int n = A[0].length; // numCols
		
		int lo, hi;
		int left, right, top, bottom;
		
        // binary search for LEFT BOUND within col (0, y);
		lo = 0; hi = y;
		while (lo+1 < hi) {
			int mid = lo + (hi-lo) /2;
			if (!hasBlackPixel(mid, 0, m-1, true)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		if (hasBlackPixel(lo, 0, m-1, true)) left = lo;
		else left = hi;
		
        // binary search for RIGHT BOUND within col (y, n);
		lo = y; hi = n-1;
		while (lo+1 < hi) {
			int mid = lo + (hi-lo) /2;
			if (hasBlackPixel(mid, 0, m-1, true)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		if (hasBlackPixel(hi, 0, m-1, true))  right = hi;
		else right = lo;
		
		// bs for TOP BOUND within row (0, x);
		lo = 0; hi = x;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo)/2;
			if (!hasBlackPixel(mid, left, right, false)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		if (hasBlackPixel(lo, left, right, false)) top = lo;
		else top = hi;
		
		// bs for bottom BOUND within row (x, m);
		lo = x; hi = m-1;
		while (lo+1 < hi) {
			int mid = lo + (hi-lo) /2;
			if (hasBlackPixel(mid, left, right, false)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		if (hasBlackPixel(hi, left, right, false))  bottom = hi;
		else bottom = lo;
		
		System.out.println("left: " + left);
		System.out.println("right: " + right);
		System.out.println("top: " + top);
		System.out.println("bottom: " + bottom);
		//System.out.println(hasBlackPixel(2, 0, 3, false));

		return (right - left + 1 ) * (bottom - top + 1);
		
    }
	
	private boolean hasBlackPixel(int colOrRow, int lowerBound, int upperBound, boolean isCol) {
		if (isCol) { // search a column
			for (int i = lowerBound; i<= upperBound; i++) {
				if (A[i][colOrRow] == '1') {
					return true;
				}
			}
			return false;
		} else { // search a row
			for (int i = lowerBound; i<= upperBound; i++) {
				if (A[colOrRow][i] == '1') {
					return true;
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		char[][] A = new char[3][4];
		A[0] = new char[] {'0','0','1','0'};
		A[1] = new char[] {'0','1','1','0'};
		A[2] = new char[] {'0','1','0','0'};
		SmallestRectangleEnclosingBlackPixels s = new SmallestRectangleEnclosingBlackPixels();
		System.out.println(s.minArea(A, 1, 2));
	}
}
