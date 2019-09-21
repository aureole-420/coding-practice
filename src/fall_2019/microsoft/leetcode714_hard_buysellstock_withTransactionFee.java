package fall_2019.microsoft;

import java.util.Arrays;

public class leetcode714_hard_buysellstock_withTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        // corner case:

        int N = prices.length;
        int[] s0 = new int[N];
        int[] s1 = new int[N];
        Arrays.fill(s1, Integer.MIN_VALUE); // 必须把s1都先置min_val, 以防万一。
        s1[0] = -prices[0];

        for (int i = 1; i < N; i++) {
            s0[i] = Math.max(s0[i-1], s1[i-1] + prices[i] - fee);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]); // 不然如果s1[j] default = 0, 这里可能成Max(0, 负数)
        }

        return Math.max(0, s0[N-1]);
    }

    public static void main(String[] args) {
        int[] prices = new int[] {1, 3, 2, 8, 4, 9};
        leetcode714_hard_buysellstock_withTransactionFee wtf = new leetcode714_hard_buysellstock_withTransactionFee();
        System.out.println(wtf.maxProfit(prices, 2));
    }
}
