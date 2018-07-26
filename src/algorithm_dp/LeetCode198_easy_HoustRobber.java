package algorithm_dp;

// 做前，好像挺简单的？
// f[i]: total money can be robbed if rob til the ith house, must robb the ith house
// init: f[0] = a[0], f[1] = a[1]
// transfer function: f[i] = f[i-2] + a[i]
// ans: MAX{f[i]}

// 做后！哇，做错了，这题很好，容易想简单。
// f[i] 并不是只跟f[i-2]相关，而是之前的都要考虑进去
// f[i] = a[i] + MAX{f[1...i-2]}

// 再看还有一种方法： f[i]: total money can be robbed til the first ith houses
// init: f[1] = a[1], f[1] = max{a[1], a[2]}
// function: f[k] = max{f[k-1], f[k-2]+A[k]}, include or exclude A[k]
// ans: f[N]
public class LeetCode198_easy_HoustRobber {
	
	public int rob(int[] nums) {
    	// corner case
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}	
    	
      int N = nums.length;
      
      if (N == 1) {
      	return nums[0];
      }    	
      
    // state:
    int[] f = new int[N];
    int[] maxSoFar = new int[N];
    
  // init:
  f[0] = nums[0];
  f[1] = nums[1];
  maxSoFar[0] = f[0];
  maxSoFar[1] = Math.max(f[0], f[1]);
  
// function:
int ans = Math.max(f[0], f[1]);
for (int i = 2; i < N; i++) {
	f[i] = maxSoFar[i-2] + nums[i];
	maxSoFar[i] =  Math.max(maxSoFar[i-1], f[i]);
	ans = Math.max(ans, f[i]);	
}
  // ans
	return ans;
	}
	
//    public int rob(int[] nums) {
//    	
//    	// corner case
//    	if (nums == null || nums.length == 0) {
//    		return 0;
//    	}
//    	
//        int N = nums.length;
//        
//        if (N == 1) {
//        	return nums[0];
//        }
//        
//        // state:
//        int[] f = new int[N];
//        
//        // init:
//        f[0] = nums[0];
//        f[1] = nums[1];
//        
//        // function:
//        int ans = Math.max(f[0], f[1]);
//        for (int i = 2; i < N; i++) {
//        	f[i] = f[i-2] + nums[i];
//        	ans = Math.max(ans, f[i]);
//        }
//        
//        // ans:
//        return ans;
//    }
}
