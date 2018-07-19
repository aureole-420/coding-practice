package algorithm_HashTable;
import java.util.*;

// 做前， 这题跟560很像，都可以用presum来做， map presum <sum, first index with that sum>

// 做后： 思路是对的，要注意一个坑：
// nums = [1, -1, 5, -2, 3], k = 3
// 第一个和为0的就是[], 
// [] -> map.put(0, -1), index 是-1
// [1] -> map.put(1, 0), index = 1
// [1, -1] -> map 不变，因为presum还是0，已经出现过了。
public class LeetCode325_medium_MaxSizeSubarraySumEqualsK {
	
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        int result = -1;
        preSum.put(0, -1); // 这一步很关键！！！
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (preSum.containsKey(sum-k)) {
        		int start = preSum.get(sum-k);
        		result = Math.max(result, i - start);
        	}
        	if (!preSum.containsKey(sum)) {
        		preSum.put(sum, i);
        	}
        }
        
        return result < 0 ? 0 : result;
    }
}
