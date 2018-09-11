package facebook_more;

// good, good, good, bad, bad, first bad version
public class LeetCode278_easy_FirstBadVersion {

    private boolean isBadVersion(int n) {
        return true;
    }

    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo+1 < hi) {
            int mid = lo + (hi-lo)/2;
            if (!isBadVersion(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (isBadVersion(lo)) {
            return lo;
        } else {
            return hi;
        }
    }

}
