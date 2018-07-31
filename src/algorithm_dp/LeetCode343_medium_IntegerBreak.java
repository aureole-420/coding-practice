package algorithm_dp;

// 不会做：
// 看了答案：有很多数学的O(n)的做法：

// 记忆化搜索
// 用dp可以O(n^2)
// state: dp[i] 分解i最大integer break
// dp[i] = Max(max(j, dp(j)) * max(i-j, dp(i-j)), j = 1,...i-1
// ans: dp[n]
public class LeetCode343_medium_IntegerBreak {
	
	public int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(Math.max(j, dp[j]), Math.max(i-j, dp[i-j]));
			}
		}
		
		return dp[n];
	}
}
