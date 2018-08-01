package algorithm_dp;

// 相对dp，更加math
public class LeetCode357_CountNumbersWithUniqueDigits {
	
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        if (n == 2) return 10 + 9*9;
        
        int[] f = new int[n+1];
        
        // in total 10 digit to choose from
        f[1] = 10;
        f[2] = 9 * 9;
        
        int ans = f[1] + f[2];
        for (int i = 3; i <= n; i++) {
        	if (i > 10) {
        		f[i] = 0;
        		break;
        	}
        	
        	f[i] = f[i-1] * (10- i + 1);
        	ans += f[i];
        }
        
        return ans;
        
    }
}
