package algorithm_dp;

import java.util.*;

//https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem

// states: C[i,j] = LCS(x[1,...,i],y[1,...,j])
// init:
// transfer function: C[i,j] = C[i-1,j-1] + 1 if x[i] == y[j]
// 反过来每次斜对角的时候： x[i] == y[j]时， result.addFirst(x[i]), i--, j--;
// otherwise: if (c[i-1, j] > c[i, j-1]), i--; otherwise j--;
// result: C[m,n] = LCS(x,y)
public class hackerrank_medium_LongestCommonSubsequences {
	
    static int[] longestCommonSubsequence(int[] a, int[] b) {
    	
    	int m = a.length, n = b.length;
    	// states;
    	int[][] C = new int[m+1][n+1];
    	
    	// init
    	for (int i = 0; i <= m; i++) {
    		C[i][0] = 0;
    	}
    	for (int j = 0; j <= n; j++) {
    		C[0][j] = 0;
    	}
    	
    	// transfer function
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j <= n; j++) {
    			if (a[i-1] == b[j-1]) {
    				C[i][j] = 1 + C[i-1][j-1];
    			} else {
    				C[i][j] = Math.max(C[i-1][j], C[i][j-1]);
    			}
    		}
    	}
    	
    	// find out ...
    	int i = m, j = n;
    	LinkedList<Integer> list = new LinkedList<>();
    	while (C[i][j] != 0) {
    		if (a[i-1] == b[j-1]) {
    			list.addFirst(a[i-1]);
    			i--;
    			j--;
    		} else {
    			if (C[i-1][j] > C[i][j-1]) {
    				i--;
    			} else {
    				j--;
    			}
    		}
    	}
    	
    	int[] res = new int[list.size()];
    	int k = 0;
    	for (int num : list) {
    		res[k] = num;
    		k++;
    	}
    	
    	return res;
    }
}
