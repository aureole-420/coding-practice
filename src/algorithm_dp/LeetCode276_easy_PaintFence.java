package algorithm_dp;

// 递推的话一定要知道第i-1个fence的颜色是什么
// dp[i][j], # of ways painting til ith posts, with color j
// init: dp[0][j] = 1;
// transition: dp[i][j] = sum_k{dp[i-1][k]}  // k != j
//   					  // if  k == j 
//						  //  if dp[i-1][j] > 0 && i-2 >=0   + dp[i-1][j] - dp[i-2][j]
//                        //  else if dp[i-1] > 0    +dp[i-1][j]


// 做中： 我意识到了！不对， 并不是 j == k时， dp[i-1][j] - dp[i-2][j]， 因为dp[i-2][j]还含有i-2， i-3都是j的情况。
// 这个时候是不能够简单相减的

// 做中：换一种dp，用state machine来做，画图见笔记本
// s1[i], s2[i], 不相同，相同
// s1[0] == k, s2[0] = 0
// s1[i] = s1[i-1]* (k-1) + s2[i-1]*(k-1)
// s2[i] = s1[i-1] * 1
					

public class LeetCode276_easy_PaintFence {
	public int numWays(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}
		int[] s0 = new int[n];
		int[] s1 = new int[n];
		
		s0[0] = k; s1[0] = 0;
		for (int i = 1; i < n; i++) {
			s0[i] = (s0[i-1] + s1[i-1]) * (k-1);
			s1[i] = s0[i-1];
		}
		
		return s0[n-1] + s1[n-1];
	}
	
	// 错误的答案
//    public int numWays(int n, int k) {
//    	// corner case
//    	if (n == 0 || k == 0) {
//    		return 0;
//    	}
//    	
//        int[][] dp = new int[n][k];
//        
//        //init 
//        for (int j = 0; j < k; j++) {
//        	dp[0][j] = 1;
//        }
//        
//        // transition
//        for (int i = 1; i < n; i++) {
//        	for (int j = 0; j < k; j++) {
//        		for (int color = 0; color < k; color++) {
//        			if (color != j) {
//        				dp[i][j] += dp[i-1][color];
//        			} else {
//        				dp[i][j] += dp[i-1][j];
//                		if (i-2 >= 0 && dp[i-1][j] > 0) {
//                			dp[i][j] -= dp[i-2][j];
//                		}
//        			}
//        		}
//        	}
//        }
//        
//        // ans
//        int ans = 0;
//        for (int color = 0; color < k; color++) {
//        	ans += dp[n-1][color];
//        }
//        return ans;
//    }
}
