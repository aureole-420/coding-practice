package algorithm_dp;


// states: f[i][j], S的前i个字符组成的string的subsequence有多少个等于T的前j个字符组成的string
// init: f[i][0] = 0, f[0][j] = 0
// function: (1) if s[i] == t[j], f[i][j] = f[i-1][j-1] + f[i-1][j] // 用或不用s[i]
//           (2) otherwise f[i][j] = f[i-1][j]
// return f[S.length][T.length]
public class LeetCode115_hard_DistinctSubsequences {
	
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        
        // states: 
        int[][] f = new int[m+1][n+1];
        
        // init
        for (int j = 0; j <= n; j++) {
        	f[0][j] = 0;
        }
        for (int i = 0; i <= m; i++) {
        	f[i][0] = 1;   // 特别注意 j=0时的初始值。
        }
        
        // transfer function
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (s.charAt(i-1) == t.charAt(j-1)) {
        			f[i][j] = f[i-1][j-1] + f[i-1][j];
        		} else {
        			f[i][j] = f[i-1][j];
        		}
        	}
        }
        
        // result
        return f[m][n];
    }	
}
