package algorithm_dp;

import java.util.*;

// 典型 two sequence dp
// states: f[i][j] a的前i个字符 -> b的前j个字符
// function：（1）f[i-1][j-1]  if a[i] == b[j]
//         // delete       //insert    // replace
// (2) MIN(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1)
// result f[a.length()][b.length()]
public class LeetCode72_hard_EditDistance {
	
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        
        // states
        int[][] f = new int[m+1][n+1];
        
        // init
        for (int i = 0; i <= m; i++) {
        	f[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
        	f[0][j] = j;
        }
        
        // transfer function
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (word1.charAt(i-1) == word2.charAt(j-1)) {
        			f[i][j] = f[i-1][j-1];
        		} else {
        			int temp = Math.min(f[i-1][j]+1, f[i][j-1]+1);
        			f[i][j] = Math.min(temp, f[i-1][j-1] + 1);
        		}
        	}
        }
        
        // result
        return f[m][n];      
    }
}
