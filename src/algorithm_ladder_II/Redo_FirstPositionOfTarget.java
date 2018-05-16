package algorithm_ladder_II;

public class Redo_FirstPositionOfTarget {
	
	public int binarySearch(int[] A, int target) {
		// corner case
		if (A == null || A.length == 0) {
			return -1;
		}
		
		
		int lo = 0, hi = A.length-1;
		while (lo+1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if (target <= A[mid]) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		
		if (A[lo] == target) {
			return lo;
		} else if (A[hi] == target) {
			return hi;
		} else {
			return -1;
		}
	}
	
	
	public static void main(String[] args) {
		int[] A = new int[] {1, 2, 3, 3, 4, 5, 10};
		int target = 111;
		Redo_FirstPositionOfTarget fp = new Redo_FirstPositionOfTarget();
		System.out.println(fp.binarySearch(A, target)); // should be 2
	}
}
