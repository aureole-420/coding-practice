package algorithm_ladder_III;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		// corner case:
		if (A==null || A.length == 0) {
			return new int[] {-1, -1};
		}
		
		int first = findBoundary(A, target, true);
		if (first == -1) return new int[] {-1, -1};
		int last = findBoundary(A, target, false);
		return new int[] {first, last};
    }
	
	// findFirst = true: find first of target
	// else find last of target;
	private int findBoundary(int[] A, int target, boolean findFirst) {
		int lo = 0, hi = A.length -1;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if ( target > A[mid]) {
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
		int[] A = new int[] {5, 7, 7, 8, 8, 10};
		int target = 8;
		SearchForARange s = new SearchForARange();
		int[] res = s.searchRange(A, target);
		System.out.println(res[0] + " " + res[1]); // should be [3, 4]
	}
}
