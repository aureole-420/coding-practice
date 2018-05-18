package algorithm_ladder_III;

/** lintcode 160 
 * 关键和search in rotated sorted array 一样：
 * 每次划分把 array分成两部分，至少有一部分是sorted，另一部分可能是sorted/rotated
 * 分类讨论即可
 * ！当区间两端相等时，缩！短！区！间！
 */
public class FindMinRotSortArrII {
	
	public int findMin(int[] A) {
		int lo = 0, hi = A.length-1;
		while (lo+1 < hi) {
			int mid = lo + (hi-lo)/2;
			if (A[mid] > A[lo]) { // left part is sorted
				if (A[hi] > A[mid]) {
					// right part is sorted as well;
					return A[lo];
				} else if (A[hi] < A[mid]) {
					// right part is rotated
					lo = mid;
				} else {
					hi--; // 缩！短！区！间！
				}
			} else if (A[mid] < A[lo]) { // left part is rotated
				hi = mid;
			} else {
				lo++; // 缩！短！区！间！
			}
		}
		
		return A[lo] < A[hi] ? A[lo] : A[hi];
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {4, 4, 5, 6, 7, 7, 1, 2};
		FindMinRotSortArrII mrsa = new FindMinRotSortArrII();
		System.out.println(mrsa.findMin(A)); // expected to be 0;
	}
}
