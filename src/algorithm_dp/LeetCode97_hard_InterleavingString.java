package algorithm_dp;


// 如果不用dp的话，s1 m, s2 n个，需要O(2^(m))

// states f[i][j] s3的前i+j个chars是不是由s1的first i chars && s2 first j chars interleaving.
// init: f[0][0] = true;   f[i][0], f[0][j]
// transfer function : f[i][j] == true (1) if s1[i] == s3[i+j] && f[i-1][j] == true
// 									   (2) if s2[j] == s3[i+j] &7 f[i][j-1] == true
//					otherwise: f[i][j] = false;
// return f[m][n]
public class LeetCode97_hard_InterleavingString {
	
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if ( m + n != s3.length()) {
        	return false;
        }
        
        // states:
        boolean[][] f = new boolean[m+1][n+1];
        
        // init
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
        	if (f[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1)) {
        		f[i][0] = true;
        	}
        }
        for (int j = 1; j <= n; j++) {
        	if (f[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1)) {
        		f[0][j] = true;
        	}
        }
        
        // transfer function
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (f[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) {
        			f[i][j] = true;
        		} else if (f[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) {
        			f[i][j] = true;
        		}
        	}
        }
        
        // result
        return f[m][n];
    }
}
