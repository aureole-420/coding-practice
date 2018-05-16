package algorithm_ladder_II;

public class Redo_SearchInRotSortArrII {
	
	public boolean search(int[] A, int target) {
		// corner case:
		if (A == null || A.length == 0) {
			return false;
		}
		
		int lo = 0, hi = A.length - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if (A[mid] == target) {
				return true;
			}
			
			if (A[mid] > A[lo]) { // left part is sorted
				if (target >= A[lo] && target <= A[mid]) {
					hi = mid;
				} else {
					lo = mid;
				}
			} else if (A[mid] <A[lo]){ // left part is rotated
				if (target >= A[mid] && target <= A[hi]) {
					lo = mid;
				} else {
					hi = mid;
				}
			} else { // else we have to move left pointer ahead (A[lo] == A[mid] != target)
				lo++;
			}
		}
		
		if (A[lo] == target) return true;
		if (A[hi] == target) return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		//int[] A = new int[] {4, 5, 6, 7, 0, 1, 2};
		int[] A = new int[] {1,1,1,1,5,1,1,1};
		int target = 5;
		Redo_SearchInRotSortArrII srsa = new Redo_SearchInRotSortArrII();
		System.out.println(srsa.search(A, target)); // should be 5
	}
}
