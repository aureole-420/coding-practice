package facebook;
import java.util.*;

// 利用 (a b) % k = ((a % k) * (b % k) ) % k

// (a ^ n) % k = [1 * (a % k) ^ n] % k
public class LeetCode372_medium_SuperPower_50followup {

    private final int BASE = 1337;

    // 0=< k <= 10
    // return a^k % BASE
    private int powmod(int a, int k) {

    a = a % BASE; //

    int result = 1;
        for (int i = 0; i < k; i++) {
        result = (result * a) % BASE;
    }

        return result;
}

    // (a ^ 32) % k = a ^ 30 * a^2 % k = (a ^ 30) % k * (a^2 % k) % k =
    public int superPow(int a, int[] b) {
        Deque<Integer> digits = new ArrayDeque<>();
        for (int digit : b) {
            digits.push(digit);
        }

        return superPow(a, digits);
    }

    private int superPow(int a, Deque<Integer> digits) {
        a = a % BASE;
        if (digits.isEmpty()) {
            return 1;
        }
        int last_digit = digits.pop();
        return (powmod( superPow(a,digits), 10) * powmod(a, last_digit)) % BASE;
    }
}
