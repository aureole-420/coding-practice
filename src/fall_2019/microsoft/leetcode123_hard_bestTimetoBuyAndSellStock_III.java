package fall_2019.microsoft;

import java.util.Arrays;

public class leetcode123_hard_bestTimetoBuyAndSellStock_III {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        // state
        int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 =Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s1 = Math.max(s1, - prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2-prices[i]); // 很神奇，不会越界！！！
            s4 = Math.max(s4, s3+prices[i]); // 很神奇啊， s4永远比s2大，yinwe s4 >= s3+prices[i] >= (s2-prices[i]) + prices[i] >= s2
            System.out.println(String.format("s1=%d, s2=%d, s3=%d, s4=%d", s1, s2, s3, s4));
        }
        return Math.max(0, s4);
    }

    public static void main(String[] args) {
        leetcode123_hard_bestTimetoBuyAndSellStock_III bbs = new leetcode123_hard_bestTimetoBuyAndSellStock_III();
//        int[] prices = new int[] {1,2,3,4,5};
        int[] prices = new int[] {1,8,5,4,3,2};
        System.out.println(bbs.maxProfit(prices));

    }
}
