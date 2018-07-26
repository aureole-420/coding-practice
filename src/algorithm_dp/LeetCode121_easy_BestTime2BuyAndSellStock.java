package algorithm_dp;


// state: f[i], 第i日卖出的最大获利
// init: f[i] = 0;
// function: f[i] = (1) if a[i] > a[i-1], f[i-1] + (a[i]-a[i-1])    (2)  a[i] - curMin
// ans: max(f[i])

// 看了答案，这题本身不难，但是出题人有可能把数据换成difference
//这时就不好找到curMin了，应该把它转换成53题，max subarray来处理，用滚动数组优化成O(1) space
public class LeetCode121_easy_BestTime2BuyAndSellStock {
	
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
        	return 0;
        }
        
        
    	int N = prices.length;
    	
    	// state:
    	int[] f = new int[N+1];
    	
    	// init: 
    	// all to zero
    	
    	// transfer function:
    	int ans = 0; // i.e. f[1]
    	for (int i = 2; i <= N; i++) {
    		f[i] = f[i-1] + prices[i-1] - prices[i-2];
    		f[i] = Math.max(0, f[i]);
    		
    		ans = Math.max(ans, f[i]);
    	}
    	
    	// ans
    	return ans;
    }
}
