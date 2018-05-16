package algorithm_ladder_II;

// O(log n)
// find interval with left increasing and right decreasing.
public class Redo_MaxNumMountSeq {

	public int findMaxNum(int[] A) {
		// corner case:
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int lo = 0, hi = A.length-1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			
			// mid should >= 1 && mid <= max-2
			if (A[mid] >= A[mid-1] && A[mid] <= A[mid+1]) {
				return mid;
			} else if (A[mid] >= A[mid-1]) { // increasing
				lo = mid;
			} else {
				hi = mid;
			}
		}
		
		return A[lo] > A[hi] ? lo : hi;
	}

	
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,4,9,8,4,3,1,-1};
//		int[] A = new int[] {7,2,1};
		Redo_MaxNumMountSeq mnms = new Redo_MaxNumMountSeq();
		System.out.println(mnms.findMaxNum(A)); // expected to be 5
	}
}
