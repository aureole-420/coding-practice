package algorithm_ladder_II;

/**
 * LintCode 585
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 * 区间两端点一阶导数异号
 */
public class MaxNumMountSeq {
	
	public int findMaxNum(int[] A) {
		// corner case
		if (A == null || A.length < 3) {
			return -1;
		}
		int lo = 0, hi = A.length-1;
		if (!(A[lo] < A[lo+1]) && !(A[hi-1] > A[hi])) { // not mountain sequence
			return -1;
		}
		
		while (lo+1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if (A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
				return mid;
			} else if (A[mid] > A[mid-1]) {
				lo = mid;
			} else {
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
		int[] A = new int[] {1,2,3,4,5,9,8,4,3,1,-1};
		MaxNumMountSeq mnms = new MaxNumMountSeq();
		System.out.println(mnms.findMaxNum(A)); // expected to be 5
	}	
}
