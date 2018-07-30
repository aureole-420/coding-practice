package algorithm_dp;

// 用309的state machine方法：
// s0 -> buy -> s1 -> sell -> s0
// s0 -> rest -> s0
// s1-> rest -> s1

// transition:
// s0[i] = max(s0[i-1], s1[i-1] + prices[i])
// s1[i] = max(s1[i-1], s0[i-1] - prices[i-1])

// init: s0[0] = 0, s1[0] = -prices[0] 
public class LeetCode122_BestTimeToBuyAndSellStock_II {
	
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) {
    		return 0;
    	}
    	
    	int N = prices.length;
    	
    	int[] s0 = new int[N];
    	int[] s1 = new int[N];
    	
    	s0[0] = 0;
    	s1[0] = -prices[0];
    	
    	for (int i = 1; i< N; i++) {
    		s0[i] = Math.max(s0[i-1], s1[i-1] + prices[i]);
    		s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]);
    	}
    	
    	return s0[N-1];
    }
}
