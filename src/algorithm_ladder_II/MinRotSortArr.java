package algorithm_ladder_II;

/**
 * leetcode 153, lintcode 159
 */
public class MinRotSortArr {
	public int findMin(int[] A) {
		// corner case;
		if (A.length == 1) return A[0];
		
		int lo = 0, hi = A.length-1;
		while (lo+1 < hi) {
			int mid = lo + (hi-lo)/2;
			if (A[mid] < A[hi]) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return Math.min(A[lo], A[hi]);
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {4, 5, 6, 7, 0, 1, 2};
		MinRotSortArr mrsa = new MinRotSortArr();
		System.out.println(mrsa.findMin(A)); // expected to be 0;
	}
}
