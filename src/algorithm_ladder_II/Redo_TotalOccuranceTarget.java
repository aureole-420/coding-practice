package algorithm_ladder_II;

public class Redo_TotalOccuranceTarget {
	
	public int totalOccurance(int[] A, int target) {
		// corner case
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int lastIndex = findIndex(A, target, false);
		int firstIndex = findIndex(A, target, true);
		
		if (firstIndex == -1 || lastIndex == -1) {
			return 0;
		} else {
			return lastIndex - firstIndex + 1;
		}
	}
	
	// 1. find first
	// A[mid]
	// 2. find last
	private int findIndex(int[] A, int target, boolean findFirst) {
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
		int[] A = new int[] {1,2,3,4,4,4,4,4,4,6,6,6,6,9,10};
		int target = 4;
		Redo_TotalOccuranceTarget tot = new Redo_TotalOccuranceTarget();
		System.out.println(tot.totalOccurance(A, target)); // should be 5
	}
		
}
