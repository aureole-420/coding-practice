package algorithm_ladder_II;

/**
 * 在一个排好序的数组 A 中找到 i 使得 A[i] 最接近 target（存在重复元素时，可返回任意一个元素的下标）
 * lintcode 459 
 *
 */
public class ClosestNumber {
	
	public int findClosestNumber(int[] A, int target) {
		// corner case:
		if (A == null || A.length == 0) {
			return -1;
		}
		int lo = 0, hi = A.length-1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] > target) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		int diff_lo = Math.abs(A[lo] - target);
		int diff_hi = Math.abs(A[hi] - target);
		System.out.println("lo = " + lo + ", diff_lo = " + diff_lo);
		System.out.println("hi = " + hi + ", diff_hi = " + diff_hi);
		
		return diff_lo < diff_hi ? lo : hi;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,7};
		int target = -1;
		ClosestNumber cn = new ClosestNumber();
	    System.out.println(cn.findClosestNumber(A, target)); // expected to be 3
	}

}
