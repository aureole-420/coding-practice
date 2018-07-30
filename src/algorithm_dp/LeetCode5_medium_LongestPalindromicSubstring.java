package algorithm_dp;

// P(i, j) = true if substring Si...Sj is palindrome 

// 看了答案，这题算matrix dp？
// transition function:
// p(i,j) = P(i+1, j-1) && Si == Sj

// base case: 
// P(i, i) = true  
// P(i, i+1) = (Si == Sj)
public class LeetCode5_medium_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	int N = s.length();
        boolean[][] p = new boolean[N][N];
        
        int maxLen = 0;
        int start = 0, end = 0;
        // base case:
        for (int i = 0; i < N; i++) {
        	p[i][i] = true;
        	if (maxLen < 1) {
        		maxLen = 1;
        		start = i; end = i+1;
        	}
        	if (i+1 < N && s.charAt(i) == s.charAt(i+1)) {
        		System.out.println(i);
        		p[i][i+1] = true;
        		if (maxLen < 2) {
        			maxLen = 2;
            		start = i; end = i+2;
            		System.out.println(start);
        		}
        		
        	}
        }
        
        for (int i = N-1; i >= 0; i--) {
        	for (int j = i+2; j < N; j++) {
        		if (p[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
        			p[i][j] = true;
        			if (j-i+1  > maxLen) {
        				System.out.println(i + " " + j + " " + maxLen);
        				maxLen = j-i+1;
        				start = i; end = j+1;
        			}
        			
        		}  		
        	}
        }
        System.out.println(start + "::"+ end);
        return s.substring(start, end);
    }
    
    public static void main(String[] args) {
    	String s = "cbbd";
    	LeetCode5_medium_LongestPalindromicSubstring lps = new LeetCode5_medium_LongestPalindromicSubstring();
    	System.out.println(lps.longestPalindrome(s));
    }
}
