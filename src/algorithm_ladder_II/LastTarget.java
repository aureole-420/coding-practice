package algorithm_ladder_II;

/**
 * lintcode 458
 * 给一个升序数组，找到target最后一次出现的位置，如果没出现过返回-1
 * 关键在于==mid时的判断
 */
public class LastTarget {
	
	public int lastPosition(int[] A, int target) {
		// corner case:
		if (A == null || A.length == 0) {
			return -1;
		}
		int lo = 0, hi = A.length-1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (A[mid] > target) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		if (A[hi] == target) {
			return hi;
		} else if (A[lo] == target) {
			return lo;
		} else {
			return -1;
		}
	}
		
	public static void main(String[] args) {
		int[] A = new int[] {1,2,2,2,4};
		int target = 2;
		LastTarget cn = new LastTarget();
	    System.out.println(cn.lastPosition(A, target)); // expected to be 2
	}
}
