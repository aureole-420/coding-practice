package algorithm_dp;

// 与309， 122 一样，用state machine 来做

// s0 -> buy -> s1 -> sell -> s0
// s0 -> rest -> s0;
// s1 -> rest -> s1;
//
// s0[i] = max(s0[i-1], s1[i-1] + prices[i])
// s1[i] = max(s1[i-1], s0[i-1] - prices[i-1] - fee)

//init: s0[0] = 0, s1[0] = -prices[0]-fee
public class LeetCode714_medium_BestTimeToBuyAndSellStockWithTransactionFee {
	
	  public int maxProfit(int[] prices, int fee) {
	    	if (prices == null || prices.length == 0) {
	    		return 0;
	    	}
	    	
	    	int N = prices.length;
	    	
	    	int[] s0 = new int[N];
	    	int[] s1 = new int[N];
	    	
	    	s0[0] = 0;
	    	s1[0] = -prices[0]-fee;
	    	
	    	for (int i = 1; i< N; i++) {
	    		s0[i] = Math.max(s0[i-1], s1[i-1] + prices[i]);
	    		s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]-fee);
	    	}
	    	
	    	return Math.max(s0[N-1], s1[N-1]);
	    }
}
