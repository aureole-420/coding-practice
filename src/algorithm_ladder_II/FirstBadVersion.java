package algorithm_ladder_II;
/**
 * lintcode 74
 *
 */

/*
public class FirstBadVersion {
	public int findFirstBadVersion(int n) {
		int lo = 1, hi = n;
        while (lo+1 < hi) {
        		int mid = lo + (hi-lo) / 2;
        		if (SVNRepo.isBadVersion(mid)) {
        			hi = mid;
        		} else {
        			lo = mid;
        		}
        }
        if (SVNRepo.isBadVersion(lo)) {
        		return lo;
        } else {
        		return hi;
        }
    }
}
*/
