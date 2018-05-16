package algorithm_ladder_II;

public class Redo_PeakElem {
 	public int findPeak(int[] A) { 
 		int lo = 0, hi = A.length-1;
 		while (lo + 1 < hi) {
 			int mid = lo + (hi-lo) / 2;
 			if (A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
 				return mid;
 			} else if (A[mid] > A[mid-1] && A[mid] < A[mid+1]) {
 				lo = mid;
 			} else {
 				hi = mid;
 			}
 		}
 		
 		if (lo > 0 && A[lo] > A[lo-1] && A[lo] > A[lo+1]) {
 			return lo;
 		} else {
 			return hi;
 		}
 	}
	public static void main(String[] args) {
		int[] A = new int[] {1, 2, 1, 3, 4, 5, 7, 6};
		Redo_PeakElem pe = new Redo_PeakElem();
		System.out.println(pe.findPeak(A)); // should be index 1 or 6
	}
}
