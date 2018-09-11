package facebook_more;

// 本身不难，用二分法(recusion)
// 100 / 3
// 每次find the largest multiple s.t. 3 * multiple <= divident,
// multiple moving from 1, 2, 4, ..., 2^n
// 跟那个find first bad version一样
public class LeetCode29_medium_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (ldivisor == 0) return Integer.MAX_VALUE;
        if (ldividend == 0) return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }

        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }

        long sum = ldivisor;
        long multiple = 1; //divisor < divident, so multiple must >= 1
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }

        // break when sum+sum > ldivident
        // e.g return ldivide(10 - 6, 3)
        return multiple + ldivide(ldividend - sum, ldivisor);


    }
}
