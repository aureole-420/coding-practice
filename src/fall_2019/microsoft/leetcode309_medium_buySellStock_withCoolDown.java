package fall_2019.microsoft;

public class leetcode309_medium_buySellStock_withCoolDown {

    public int maxProfit(int[] prices) {
        // corner case
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int N = prices.length;
        int[] s0 = new int[N], s1 = new int[N], s2 = new int[N];
        s1[0] = -prices[0];

        for (int i = 1; i < N; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]);
            s2[i] = s1[i-1]+prices[i];
        }

        return Math.max(0, Math.max(s0[N-1], s2[N-1]));
    }
}
