package algorithm_dp;

// state: f[i], 以第i个元素结尾的ontiguous subarray的largest sum
// init: f[i] = a[i], i = 1,2,...,N
// function: f[i] = Max(f[i-1] + nums[i], nums[i])
// answer: max(f[i])
public class LeetCode53_easy_MaxSubarray {
	
    public int maxSubArray(int[] nums) {
    	
    	// corner case:
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	
        int N = nums.length;
        
        // state
        int[] f = new int[N+1];
        
        // init
        for (int i = 1; i <= N; i++) {
        	f[i] = nums[i-1];
        }
        
        // function:
        int ans = f[1]; // 这里不能取integer.min_value!!!
        for (int i = 2; i <= N; i++) {
        	f[i] = Math.max(f[i-1] + nums[i-1], nums[i-1]);
        	ans = Math.max(ans, f[i]);
        }
        
        // answer
        return ans;
        
    }
    
}
