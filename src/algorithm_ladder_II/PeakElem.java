package algorithm_ladder_II;

/**
 * Lintcode 75
 * Find Peak Element 
 *
 */
public class PeakElem {
    	public int findPeak(int[] A) {
		int lo = 0, hi = A.length-1;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo) / 2; // at least 3 elements in A
			if (A[mid] > A[mid-1] && A[mid] > A[mid+1]) {  // function shape: /\
				return mid;
			} else if (A[mid] < A[mid+1] && A[mid-1] < A[mid]) { // function shape: / /
				lo = mid;
			} else { // function shape: \/ OR \ \
				hi = mid;
			}
		}
		if (A[lo] > A[lo-1] && A[lo] > A[lo+1]) {
			return lo;
		} else {
			return hi;
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1, 2, 1, 3, 4, 5, 7, 6};
		PeakElem pe = new PeakElem();
		System.out.println(pe.findPeak(A)); // should be index 1 or 6
	}
}
