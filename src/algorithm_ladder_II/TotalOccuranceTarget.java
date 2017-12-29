package algorithm_ladder_II;

/**
 * Lintcode 462 
 * Given a target number and an integer array sorted in ascending order. 
 * Find the total number of occurrences of target in the array.
 *
 */
public class TotalOccuranceTarget {
	
	public int totalOccurance(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int indexOfFirst = findTarget(A, target, true);
		if (indexOfFirst == -1) return 0;
		
		int indexOfLast = findTarget(A, target, false);
		return indexOfLast - indexOfFirst + 1;
	}
	
	// findFirst = true : find the first target;
	// findFirst = false : find the last target;
	// return -1 if not found;
	private int findTarget(int[] A, int target, boolean findFirst) {
		int lo = 0, hi = A.length-1;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if (target > A[mid]) {
				lo = mid;
			} else if (target < A[mid]) {
				hi = mid;
			} else {
				if (findFirst) {
					hi = mid;
				} else {
					lo = mid;
				}
			}
		}
		
		if (findFirst) {
			if (A[lo] == target) return lo;
			else if (A[hi] == target) return hi;
			else return -1;
		} else {
			if (A[hi] == target) return hi;
			else if (A[lo] == target) return lo;
			else return -1;
		}
			
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,4,4,4,4,4,6,6,6,6,9,10};
		int target = 4;
		TotalOccuranceTarget tot = new TotalOccuranceTarget();
		System.out.println(tot.totalOccurance(A, target)); // should be 5
		
	}
}
