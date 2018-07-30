package algorithm_dp;

//s0[i][j]， 第i天交易了j次， j=0,1....,k 
public class LeetCode188_hard_BestTimeToBuyAndSellStock_IV {

	// 滚动数组的做法，才能不超时
	public int maxProfit(int k, int[] prices) {
    	if (prices == null || prices.length == 0) {
    		return 0;
    	}
    	
    	
    	
    	int N = prices.length;
    	k = Math.min(k, N/2);
        int[][] s0 = new int[2][k+1];
        int[][] s1 = new int[2][k+1];
        
        // init
        s0[0][0] = 0; s1[0][0] = -prices[0];
        for (int j = 1; j <= k; j++) {
        	s0[0][j] = Integer.MIN_VALUE;
        	s1[0][j] = Integer.MIN_VALUE;
        }
//        
        // transition function
        int minCost = -prices[0];
        for (int i = 1; i < N; i++) {
        	for (int j = 1; j <= k && 2 * j <= i+1; j++) {      		
        		s0[i % 2][j] = Math.max(s0[(i-1) % 2][j], s1[(i-1) % 2][j-1]+prices[i]);
        		s1[i % 2][j] = Math.max(s1[(i-1) % 2][j], 2*j > i ? Integer.MIN_VALUE : s0[(i-1) % 2][j]-prices[i]);
        	}
        	// 还得把s1[i][j]求一下，方便计算一下一行。
        	if (-prices[i] > minCost) {
        		minCost = -prices[i]; 		
        	} 
        	s1[i % 2][0] = minCost;
        }
        
        // ans:
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j <= k && 2*j <= N; j++) {
        	ans = Math.max(ans, s0[(N-1) % 2][j]);
        }
        return ans;
    }
	
//    public int maxProfit(int k, int[] prices) {
//    	if (prices == null || prices.length == 0) {
//    		return 0;
//    	}
//    	
//    	
//    	
//    	int N = prices.length;
//    	k = Math.min(k, N/2);
//        int[][] s0 = new int[N][k+1];
//        int[][] s1 = new int[N][k+1];
//        
//        // init
//        s0[0][0] = 0; s1[0][0] = -prices[0];
//        int minCost = -prices[0];
//        for (int i = 1; i < N; i++) {
//        	if (-prices[i] > minCost) {
//        		minCost = -prices[i];
//        		
//        	} 
//        	s1[i][0] = minCost;
//        }
//        for (int j = 1; j <= k; j++) {
//        	s0[0][j] = Integer.MIN_VALUE;
//        	s1[0][j] = Integer.MIN_VALUE;
//        }
//        
//        // transition function
//        for (int i = 1; i < N; i++) {
//        	for (int j = 1; j <= k && 2 * j <= i+1; j++) {
//        		
//        		s0[i][j] = Math.max(s0[i-1][j], s1[i-1][j-1]+prices[i]);
//        		s1[i][j] = Math.max(s1[i-1][j], 2*j > i ? Integer.MIN_VALUE : s0[i-1][j]-prices[i]);
//        		System.out.println("----------" + i + ","+ j +"------------");
//        		System.out.println("<a>" + i + " " + j + "::"+s0[i-1][j]+"::"+s1[i-1][j-1]+"+"+prices[i] +"="+(s1[i-1][j-1]+prices[i]));
//        		System.out.println("<b>" + i + " " + j + "::"+s1[i-1][j]+"::"+s0[i-1][j]+"+"+prices[i] +"="+(s0[i-1][j]-prices[i]));
//        		System.out.println("<c>" + i + " " + j + "::"+s0[i][j]+"::"+s1[i][j]);
//        	}
//        }
//        
//        // ans:
//        int ans = Integer.MIN_VALUE;
//        for (int j = 0; j <= k && 2*j <= N; j++) {
//        	ans = Math.max(ans, s0[N-1][j]);
//        }
//        return ans;
//    }
    
    public static void main(String[] args) {
    	int k = 2;
    	int[] prices = new int[] {1,2,4,7};
    	LeetCode188_hard_BestTimeToBuyAndSellStock_IV bt = new LeetCode188_hard_BestTimeToBuyAndSellStock_IV();
    	System.out.println(bt.maxProfit(k, prices));
//    	System.out.println(Integer.MIN_VALUE + 1);
    }
}
