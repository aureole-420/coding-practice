package algorithm_dp;

//做前： 典型的two sequence dp
//e.g s: "ab"  p: "a*"
//state: f[i][j]: s的前i个字母 和 p的前j个字母是否匹配
//init: f[0][0] = true,  f[1...N][0] = false;
//transfer function: f[i][j] (1) if p[j] is Char,  => f[i-1][j-1] && p[j] == s[i]
//							  (2) if p[j] is "?" => f[i-1][j-1]
//							  (3) if p[j] is "*" => OR{f[0,....,i][j-1]}  / f[i-1][j]
//ans: f[N][M] 

// 做后，不对，if p[j] is "*"并不是 f[i][j] = f[i-1][j]
// 而是 f[i][j] = f[i-1][j] || f[i][j-1]
//             '*'for s[i]  || '*' for empty string
public class LeetCode44_hard_WildcardMatching {
	
    public boolean isMatch(String s, String p) {
        
    	// corner
    	if (s == null || p == null) {
    		return false;
    	}
    	
    	// state
    	int N = s.length(), M = p.length();
    	boolean[][] f = new boolean[N+1][M+1];
    	
    	// init
    	f[0][0] = true;
    	for (int j = 1; j <= M; j++) {
    		if (p.charAt(j-1) != '*') {
    			break;
    		}
    		f[0][j] = true;
    	}
    	
    	// transfer function
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= M; j++) {
    			
    			if (p.charAt(j-1) != '?' && p.charAt(j-1) != '*') { // if char
    				if (p.charAt(j-1) == s.charAt(i-1)) {
    					f[i][j] = f[i-1][j-1];
    					System.out.println("(i,j)" + i + " " + j + " : " + f[i][j]);
    				} else {
//    					f[i][j] = false;
//    					System.out.println("<i,j>" + i + " " + j + " : " + f[i][j]);
    				}
    			}
    			
    			if (p.charAt(j-1) == '?') {
    				f[i][j] = f[i-1][j-1];
    				System.out.println("<i,j>" + i + " " + j + " : " + f[i][j]);
    			}
    			
    			if (p.charAt(j-1) == '*') {
    				f[i][j] = f[i-1][j];
    				System.out.println("[i,j]" + i + " " + j + " : " + f[i][j]);
    			}
    		}
    	}
    	
    	// ans:
    	return f[N][M];
    }
    
    public static void main(String[] args) {
    	LeetCode44_hard_WildcardMatching rem = new LeetCode44_hard_WildcardMatching();
    	String s = "adceb";
    	String p = "*a*b";
    	System.out.println(rem.isMatch(s, p));
    }
}
