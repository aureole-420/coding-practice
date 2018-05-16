package algorithm_ladder_II;


/**
 * LintCode 447
 * 给一个按照升序排序的正整数数组。这个数组很大以至于你只能通过固定的接口 ArrayReader.get(k) 来访问第k个数。
 * 并且你也没有办法得知这个数组有多大。找到给出的整数target第一次出现的位置。
 * 你的算法需要在O(logk)的时间复杂度内完成，k为target第一次出现的位置的下标。如果找不到target，返回-1
 *
 */
// iteratively implement binary search
//public class Redo_SearchInBigArray {
//	
//	public int findIndex(int target) {
//		// corner case:
//		if (ArrayReader.get(0) > target) {
//			return -1;
//		}
//		
//		int sz = 1;
//		while (ArrayReader.get(sz) < target) {
//			sz = sz * 2;
//		}
//		
//		int lo = sz / 2, hi = sz;
//		while (lo + 1 < hi) {
//			int mid = lo + (hi-lo) / 2;
//			if (target > ArrayReader.get(mid)) {
//				lo = mid;
//			} else {
//				hi = mid;
//			}
//		}
//		
//		if (ArrayReader.get(lo) == target) {
//			return lo;
//		} else if (ArrayReader.get(hi) == target) {
//			return hi;
//		} else {
//			return -1;
//		}
//	}
//}
