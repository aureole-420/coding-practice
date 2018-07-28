package algorithm_dp;

// sequence dp
// state f[i], max product of contiguous subarray til the ith one.
// init: f[i] = a[i]
// function: f[i] = max(a[i], a[i]*f[i-1]); --- 仔细一想，如果全是正数当然是这样

// 但如果是负数？  e.g 2  -2， 3， -1

// 子问题是： 前一个序列的最大与最小
// f[i], 最大
// g[i], 最小
// function: f[i] = MAX{a[i], a[i]*f[i-1], a[i]*g[i-1]}
// g[i] = MIN{a[i], a[i]*f[i-1], a[i]*g[i-1]}

// 做后，证明想对了：
//compare among max * A[i], min * A[i] as well as A[i], since this is product, a negative * negative could be positive.
public class LeetCode152_medium_MaxProductSubarray {
	
	// 
    public int maxProduct(int[] nums) {
    	
    	// corner case:
    	if (nums == null || nums.length == 0) {return 0;}
        
    	int N = nums.length;
    	
    	// state
    	int[] f = new int[N+1];
    	int[] g = new int[N+1];
    	
    	// init
    	f[0] = 1; g[0] = 1;
    	for (int i = 1; i <= N; i++) {
    		f[i] = nums[i-1];
    		g[i] = nums[i-1];
    	}
    	
    	// transfer function:
    	for (int i = 1; i <= N; i++) {
    		f[i] = Math.max(f[i], nums[i-1] * f[i-1]);
    		f[i] = Math.max(f[i], nums[i-1] * g[i-1]);
    		
    		g[i] = Math.min(g[i], nums[i-1] * f[i-1]);
    		g[i] = Math.min(g[i], nums[i-1] * g[i-1]);
    	}
    	
    	// ans
    	int res = Integer.MIN_VALUE;
    	for (int i = 1; i <= N; i++) {
    		res = Math.max(res, f[i]);
    	}
    	return res;    	
    }
}
