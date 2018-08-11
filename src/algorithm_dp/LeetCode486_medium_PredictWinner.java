package algorithm_dp;
import java.util.*;

// 做前：感觉这题可以用memoization或者dp，非常典型
public class LeetCode486_medium_PredictWinner {
	
    public boolean PredictTheWinner(int[] nums) {
    	int N = nums.length;
        int[][] cache = new int[N][N];
        
        int[] preSum = new int[N+1];
        for (int i = 1; i <= N; i++) {
        	preSum[i] = preSum[i-1] + nums[i-1];
        }
        int sum = preSum[N];
        
        if (2 * pick(0, N-1, nums, cache, preSum) >= sum) {
        	return true;
        }
        return false;
    }
    
    private int pick(int start, int end, int[] nums, int[][] cache, int[] preSum) {
    	if (start > end) {
    		return 0;
    	}
    	
    	if (cache[start][end] > 0) {
    		return cache[start][end];
    	}
    	
    	// base case
    	if (start == end) {
    		cache[start][end] = nums[start];
    		return nums[start];
    	}
    	
    	int pickLeft = nums[start] + preSum[end+1] - preSum[start+1] - pick(start+1, end, nums, cache, preSum);
    	int pickRight = nums[end] + preSum[end] - preSum[start] - pick(start, end-1, nums, cache, preSum);
    	int ans = Math.max(pickLeft, pickRight);
    	cache[start][end] = ans;
    	
    	return ans;
    }
}
