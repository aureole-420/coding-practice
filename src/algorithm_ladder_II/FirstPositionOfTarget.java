package algorithm_ladder_II;

/**
 * Lintcode 14 easy
 */
public class FirstPositionOfTarget {
	public int binarySearch(int[] A, int target) {
		// corner case;
		if (A == null || A.length == 0) 
			return -1;
		
		int lo = 0, hi = A.length-1;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if (target > A[mid]) {
				lo = mid;
			} else if (target < A[mid]) {
				hi = mid;
			} else {
				hi = mid;
			}
		}
		if (A[lo] == target) 
			return lo;
		else if (A[hi] == target) 
			return hi;
		else 
			return -1;
    }
	
	public static void main(String[] args) {
		int[] A = new int[] {1, 2, 3, 3, 4, 5, 10};
		int target = 3;
		FirstPositionOfTarget fp = new FirstPositionOfTarget();
		System.out.println(fp.binarySearch(A, target)); // should be 2
	}
}
