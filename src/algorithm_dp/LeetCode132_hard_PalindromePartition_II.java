package algorithm_dp;


// 做前：没有思路

// 做中： 1. 序列， 有序，不能交换 2. 求最大最小  ---- 想到用dp 
// 要用到dp，就一定要利用子问题，n ~ n-1, n-2, n-3, ... 
// state: f[i] 【前i个字符】组成的字符串成需要最少几次cut （分成多少个字符串-1）, i = 0, 1, 2, ...,n
// transfer function: f[i] = min{f[j] + 1} && j < i && j+1 ~i是回文串, j= 0, 1, ... i-1

// improvement，可以把state改为更intuitive的 f[i] 前i个字符组成的字符串最少有多少个回文串组成。结果需要-1

// 现有O(n^3), 可以预处理回文串，用O(n^2) time + space来先求的isPalindrome,  
public class LeetCode132_hard_PalindromePartition_II {
	
	
    public int minCut(String s) {
        
    	int N = s.length();
    	
    	// states;
    	int[] f = new int[N+1];
    	
    	// init
    	f[0] = -1;
    	
    	// transfer
    	for (int i = 1; i <= N; i++) {
    		int minCut = Integer.MAX_VALUE;
    		for (int j = 0; j < i; j++) {
    			if (isPalindrome(s, j+1, i)) {
    				minCut = Math.min(minCut, f[j] + 1);
    			}
    		}
    		f[i] = minCut;
    	}
    	
    	
    	
    	// result
    	return f[N];
    }
    
    // inclusive,
    // start: end, 1, 2, ....,N
    private boolean isPalindrome(String s, int start, int end) {
    	for (int i = start, j = end; i < j; i++, j--) {
    		if (s.charAt(i-1) != s.charAt(j-1)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
