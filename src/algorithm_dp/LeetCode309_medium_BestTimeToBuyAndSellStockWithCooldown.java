package algorithm_dp;

// 看了答案：
// 3个动作：buy, sell, rest
// 状态在这三个动作中转换
// s0 -> buy -> s1 -> sell -> s2 -> rest ->s0 
// self loop, s0 -> rest -> s0, s1-> rest->s1
// 三个状态s0[i], 第i天以该状态结束的最大获利
// ans: max(s0[N], s2[N])

// transition function:
// s0[i] = max(s0[i-1], s2[i-1])  。。。。。（1.1）
// s1[i] = max(s0[i-1] - prices[i], s1[i-1]) 。。。。。（1.2）
// s2[i] =  s1[i-1] + prices[i] 。。。。。（1.3）

// 起始状态：
// s0[0] = 0;
// s1[0] = - prices[0]
// s2[0] = int_min // 事实上不可能第一步就sell，所以在transition （1.1）时确保s0[1] = s0[0]即可

// ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
public class LeetCode309_medium_BestTimeToBuyAndSellStockWithCooldown {
	
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) {
    		return 0;
    	}
    	
    	int N = prices.length;
        int[] s0 = new int[N];
        int[] s1 = new int[N];
        int[] s2 = new int[N];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        
        for (int i = 1; i < N; i++) {
        	s0[i] = Math.max(s0[i-1], s2[i-1]);
        	s1[i] = Math.max(s0[i-1] - prices[i], s1[i-1]);
        	s2[i] = s1[i-1]+ prices[i];
        }
        
        return Math.max(s0[N-1], s2[N-1]);
    }
}
