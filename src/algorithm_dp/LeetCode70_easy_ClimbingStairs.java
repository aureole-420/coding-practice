package algorithm_dp;

// 典型的sequence dp
// f(i) 跳到i的方法
// f(1) = 1
// f(i) = f(i-1) + f(i-2)
public class LeetCode70_easy_ClimbingStairs {
	
    public int climbStairs(int n) {
    	if (n == 1) {
    		return 1;
    	}
    	
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < n+1; i++) {
        	f[i] = f[i-1] + f[i-2];
        }
        
        return f[n];
    }
}
