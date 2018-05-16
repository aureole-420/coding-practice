package algorithm_ladder_II;

public class Redo_MinRotSortArr {
	
	public int findMin(int[] A) { 
		// corner case:
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int lo = 0, hi = A.length-1;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo)/2;
			if (A[mid] >= A[lo]) {
				lo = mid;
			} else if (A[mid] <= A[hi]) {
				hi = mid;
			}
		}
		
		return A[lo] < A[hi] ? lo : hi;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {4, 5, 6, 7, 0, 1, 2};
		Redo_MinRotSortArr mrsa = new Redo_MinRotSortArr();
		System.out.println(mrsa.findMin(A)); // expected to be 0;
	}
}
