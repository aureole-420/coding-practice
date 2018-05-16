package algorithm_bfs_dfs;

/*
 * Leetcode 279
 * Dynamic programming
 */
public class PerfectSquares {
	/*
    public int numSquares(int n) {
    		if (n == 0) return 0;
    		int res = n; // 1*1 + 1*1 +... + 1*1
        for (int i = 1; i*i <= n; i++) {
        		if (i*i > n) break;
        		else {
        			res = Math.min(res, 1 + numSquares(n-i*i));
        		}
        }
        return res;
    }
    */
	public int numSquares(int n) {
		// dp[k] == the Minimum number of squares whose sum equals to given number k
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else if (n == 2) return 2;
		else if (n == 3) return 3;
		
		int[] dp = new int[n+1]; // 0, 1, 2, ..., n
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		// compute dp[i]
		for (int i = 4; i <= n; i++) {
			dp[i] = i;
			for (int x = 1; x * x <= i; x++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
			}
		}
		return dp[n];
	}
    
    public static void main(String[] args) {
    		PerfectSquares p = new PerfectSquares();
    		System.out.println(p.numSquares(100)); // should be 2;
    }
}
