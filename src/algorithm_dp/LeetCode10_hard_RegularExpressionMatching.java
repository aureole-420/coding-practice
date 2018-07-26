package algorithm_dp;

// 可以用有限自动机做，
// 但我现在不太清楚那个怎么做，所以先用dp

// 做前： 典型的two sequence dp
// e.g s: "ab"  p: "a*"
// state: f[i][j]: s的前i个字母 和 p的前j个字母是否匹配
// init: f[0][0] = true, f[1...N][0] = false, f[0][1...M] = false;
// transfer function: f[i][j] (1) if p[j] is Char,  => f[i-1][j-1] && p[j] == s[i]
// 							  (2) if p[j] is "." => f[i-1][j-1]
// 							  (3) if p[j] is "*" => OR{f[0,....,i][j-1]}
// ans: f[N][M]

// 做中： 不对劲，这个*并不是RE的*，而是表示任意次
//transfer function: f[i][j] (1) if p[j] is Char,  => f[i-1][j-1] && p[j] == s[i]
// (2) if p[j] is "." => f[i-1][j-1]
// (3) if p[j] is "*" => (3.1) if p[j-1] != s[i] => f[i][j] = f[i][j-2] // in this case, a* only counts as empty.
// 						(3.2) if p[j-1] == s[i] or p[j-1] == '.'
//                              f[i][j] = f[i-1][j] || f[i][j-1] || f[i][j-2]
//             a* for multiple a || a* for single a || a* for empty string
// 做后，leetcode44才是常见的wild card matching
// 这题非常难，
// init我也搞错了，看下面才是正确的。

public class LeetCode10_hard_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	
    	// TODO: corner case: 
    	if (s == null || p == null) {
    		return false;
    	}
    	
    	
        int N = s.length(), M = p.length();
    	// suppose N > 0, M > 0
        //state
        boolean[][] f = new boolean[N+1][M+1];
        
        // init
        f[0][0] = true;
        for (int j = 1; j <= M; j++) {
        	if (p.charAt(j-1) == '*' && f[0][j-2]) { // j >= 2  //在这里犯了错，是f[0][j-2] 而不是f[0][j-1]
        		f[0][j] = true;
        	}
        }
       
        
        // function
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= M; j++) {
        		
        		if (p.charAt(j-1) != '.' && p.charAt(j-1) != '*') { // char
        			if (p.charAt(j-1) == s.charAt(i-1)) {
        				f[i][j] = f[i-1][j-1];
        				System.out.println(i + " " + j + ": " + f[i][j]);
        			} // else false;    			
        		} 
        		
        		if (p.charAt(j-1) == '.') {
        			f[i][j] = f[i-1][j-1];
        			System.out.println(i + " " + j + ": " + f[i][j]);
        		} 
        		
        		if (p.charAt(j-1) == '*') { // j 至少为2
//        			System.out.println("that is called.");
        			if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.') { // repeat zero times
//        				System.out.println("here is called." + i + j);
        				f[i][j] = f[i][j-2];
        				System.out.println(i + " " + j + ": " + f[i][j]);
        			} else { // p[j-1] == s[i] or p[j-1] == '.'
        				System.out.println("this is called."+i + j);
        				f[i][j] = f[i-1][j] || f[i][j-1] || f[i][j-2];
        				System.out.println(i + " " + j + ": " + f[i][j]);
        			}
        		}
        	}
        }
        
        return f[N][M];     
    }
    
//    public boolean isMatch(String s, String p) {
//    	
//    	// TODO: corner case: 
//    	
//        int N = s.length(), M = p.length();
//    	// suppose N > 0, M > 0
//        //state
//        boolean[][] f = new boolean[N+1][M+1];
//        
//        // init
//        f[0][0] = true;
//        for (int i = 1; i <= N; i++) {
//        	f[i][0] = false;
//        }
//        for (int j = 1; j <= M; j++) {
//        	f[0][j] = false;
//        }
//        
//        // transfer 
//        for (int )
//        
//        
//    }
    
    public static void main(String[] args) {
    	LeetCode10_hard_RegularExpressionMatching rem = new LeetCode10_hard_RegularExpressionMatching();
    	String s = "aab";
    	String p = "c*a*b";
    	System.out.println(rem.isMatch(s, p));
    }
    
}
