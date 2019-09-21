package fall_2019.microsoft;

public class leetcode188_hard_buysellstock_iv {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k <= 0) { // if no transaction can be made
            return 0;
        }
        int N = prices.length;
        int K = Math.min(k, N / 2);
        System.out.println("K="+K);
        int[] buy = new int[K];
        int[] sell = new int[K];

        // init
        buy[0] = - prices[0];
        // rest part
        for (int j = 1; j < K; j++) {
            buy[j] = Integer.MIN_VALUE;
        }

        // transition
        for (int i = 0; i < N; i++) {
            System.out.print(String.format("i=%d ", i));
                buy[0] = Math.max(buy[0], -prices[i]);
                sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < K; j++) {
                buy[j] = Math.max(buy[j],  sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                System.out.print(String.format(" buy[%d]=%d, sell[%d]=%d", j, buy[j], j, sell[j]));
            }
            System.out.print("\n");
        }
        return Math.max(0, sell[K-1]);
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{2,4,1};
//        int[] prices = new int[]{3,2,6,5,0,3};
        int[] prices = new int[]{3,3,5,0,0,3,1,4};


        leetcode188_hard_buysellstock_iv bs = new leetcode188_hard_buysellstock_iv();
        System.out.println(bs.maxProfit(2, prices));
    }
}
