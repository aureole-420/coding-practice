package facebook;

public class LeetCode50_medium_PowXn {

    // n > 0
    private double power(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1.0 / x;
            N = -N;
        }

        return power(x, N);
    }

}
