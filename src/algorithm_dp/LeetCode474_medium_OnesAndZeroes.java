package algorithm_dp;

// 做前：觉得是三维：dp[i][m][n], max number of string with m 0 and n 1
// dp[i][m][n] = Math.max(dp[i-1][m][n], 1 + dp[i-1][m-#0][n-#1])

// 看了答案，差不多的，不过可以用滚动数组，所以只需要用dp[m][n]就可以了
public class LeetCode474_medium_OnesAndZeroes {

    public int findMaxForm(String[] strs, int M, int N) {

        // corner case:
        if (strs == null || strs.length == 0) {
            return 0;
        }

        int[][][] dp = new int[strs.length][M+1][N+1];


        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int[] temp = countOnesAndZeroes(s);
            for (int m = 0; m <= M; m++) {
                for (int n = 0; n <= N; n++) {
                    if (i == 0) { // the first string
                        dp[0][m][n] = (temp[0] <= m && temp[1] <= n) ? 1 : 0;
                    } else {
                        if (temp[0] <= m && temp[1] <= n) { // the ith string can be put into subset
                            dp[i][m][n] = Math.max(dp[i-1][m][n], 1 + dp[i-1][m-temp[0]][n-temp[1]]);
                        } else {
                            dp[i][m][n] = dp[i-1][m][n];
                        }
                    }
                }
            }
        }

        return dp[strs.length-1][M][N];
    }

    private int[] countOnesAndZeroes(String s) {
        int[] ans = new int[2];
        for (int c : s.toCharArray()) {
            ans[c-'0']++;
        }

        return ans;
    }
}
