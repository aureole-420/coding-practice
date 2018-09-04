package facebook;

// find the largest num that num*num < x
// 改写： 避免溢出 num < 1.0 * x / num
public class LeetCode69_easy_SqrtX {

    // non negative
//    public int mySqrt(int n) {
//        if (n == 0) {
//            return 0;
//        }
//
//        int lo = 0, hi = n;
//        while (lo + 1 < hi) {
//            int mid = lo + (hi-lo)/2;
//            System.out.println(hi + "::" + lo + "::"+"mid" + mid);
//            if (mid < n * 1.0 / mid) {
//                System.out.println("case 1");
//                lo = mid;
//            } else if (mid > n * 1.0 / mid) {
//                System.out.println("case 2");
//                hi = mid;
//            } else {
//                System.out.println("case 3");
//                return mid;
//            }
//        }
//
//        System.out.println(lo + " " + hi);
//        if (hi <= n / hi) return hi;
//
//        else return lo;
//    }

    public int mySqrt(int n) {
        if (n == 0) {
            return 0;
        }

        int lo = 1, hi = n;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid < n * 1.0 / mid) {
                lo = mid;
            } else if (mid > n * 1.0 / mid) {
                hi = mid;
            } else {
                return mid;
            }
        }

        if (hi <= n *1.0 / hi) return hi;
        return lo;
    }

    public static void main(String[] args) {
        LeetCode69_easy_SqrtX sq = new LeetCode69_easy_SqrtX();

        System.out.println(sq.mySqrt(6)); // should 2
        System.out.println(sq.mySqrt(4)); // should 2
        System.out.println(sq.mySqrt(3)); // should 2
        System.out.println(sq.mySqrt(0)); // should 2
        System.out.println(sq.mySqrt(1)); // should 2
    }
}
