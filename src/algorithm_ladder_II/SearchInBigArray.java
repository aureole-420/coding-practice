package algorithm_ladder_II;

/**
 * LintCode 447
 * 给一个按照升序排序的正整数数组。这个数组很大以至于你只能通过固定的接口 ArrayReader.get(k) 来访问第k个数。
 * 并且你也没有办法得知这个数组有多大。找到给出的整数target第一次出现的位置。
 * 你的算法需要在O(logk)的时间复杂度内完成，k为target第一次出现的位置的下标。如果找不到target，返回-1
 *
 */
/** 
public class SearchInBigArray {
	public int findIndex(int target) {
		int i = 0;
		if (ArrayReader.get(i) == target) {
			return i;
		}
		i = 1;
		while (ArrayReader.get(i) < target) {
			i *= 2;
		}
		int lo = i/2, hi = i;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if (ArrayReader.get(mid) >= target) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		if (ArrayReader.get(lo) == target) {
			return lo;
		} else if (ArrayReader.get(hi) == target) {
			return hi;
		} return -1;
	}
}
*/
