package algorithm_dp;

// 看了答案： 
// lps(i,j), i~j内的subsequence的长度
// transition：
// lps(i,j) = if s.charat(i) == s.charat(j), lp(i+1, j-1) + 2
//         = otherwise, max(lps(i+1, j), lps(i,j-1))

// 递推是（i,j） <- (i+1, j-1),也就是自己左下方，所应该从bottom 到 top
public class LeetCode516_medium_LongestPalindromicSubsequence {
	
	public int longestPalindromeSubseq(String s) {
		int N = s.length();
		int[][] dp = new int[N][N];
		
		// init
		for (int i = 0; i < N; i++) {
			dp[i][i] = 1;
		}
		
		// 
		for (int i = N-2; i>= 0; i--) {
			for (int j = i+1; j < N; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i+1][j-1] + 2; // even if i+1 > j-1, its default to be zero.
				} else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[0][N-1];
	}
}
