package algorithm_HashTable;
import java.util.*;
// 做前： 首先确定无论如何是要检查：n(n-1)/2个区间的值的
// 问题是每个区间的检查的代价是多少？O(1)还是O(n)
// 我的思路是用hashmap存储中间结果， 移动end指针时，把所有现有map.get(start-end) + nums[end++]就是
// start就是剪

// 做中： 居然超时了！
// 改进：用two array来表示 --- 哦，这不就是dp嘛

// 这题way too brilliant！！！
// 只存presum, 用sum-presum的差来表示subarray； 用map存presum，可以O(1)检索是否存在满足条件的presum， i.e. subarray
public class LeetCode560_medium_SubarraySumEqualsK {
	
	public int subarraySum(int[] nums, int k) {
		int sum = 0,  result = 0;
		HashMap<Integer, Integer> preSum = new HashMap<>(); // <sum, countOfThatSum>
		
		preSum.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum-k)) {
				result += preSum.get(sum-k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
		}
		
		return result;
	}
	
	// 第二个超时的答案！！！改进版的dp
//    public int subarraySum(int[] nums, int k) {
//    		int start = 0, end = 0;
//        int[][] map = new int[nums.length][nums.length+1];
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//        		map[i][i] = 0;
//        }
//        while (end < nums.length) {
//        		map[start][end+1] = map[start][end] + nums[end];
//        		if (map[start][end+1] == k) {
//        			count++;
//        		}
//        		end++;
//
//        }
//        
//        // now end = n
//        // shrink winow a step forward.
//        while (start < nums.length) {
//        		int val2Del = nums[start];
//        		start++;
//        		for (int tempEnd = start+1; tempEnd <= nums.length; tempEnd++) {
//        			map[start][tempEnd] = map[start-1][tempEnd] - val2Del;
//        			if (map[start][tempEnd] == k) {
//        				count++;
//        			}
//        		}
//        }
//        
//        return count;
//    }
    
    
//    public int subarraySum(int[] nums, int k) {
//		int start = 0, end = 0;
//    HashMap<String, Integer> map = new HashMap<>();
//    
//    int count = 0;
//    for (int i = 0; i < nums.length; i++) {
//    		map.put(i+"@"+i, 0);
//    }
//    while (end < nums.length) {
//    		map.put(start+"@"+(end+1), map.get(start+"@"+end) + nums[end]);
//    		if (map.get(start+"@"+(end+1)) == k) {
//    			count++;
//    		}
//    		end++;
//
//    }
//    
//    // now end = n
//    // shrink winow a step forward.
//    while (start < nums.length) {
//    		int val2Del = nums[start];
//    		start++;
//    		for (int tempEnd = start+1; tempEnd <= nums.length; tempEnd++) {
//    			map.put(start+"@"+tempEnd, map.get((start-1)+"@"+tempEnd)-val2Del);
//    			if (map.get(start+"@"+tempEnd) == k) {
//    				count++;
//    			}
//    		}
//    }
//    
//    return count;
//}
}
