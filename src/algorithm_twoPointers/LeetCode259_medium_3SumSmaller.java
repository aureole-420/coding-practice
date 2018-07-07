package algorithm_twoPointers;

import java.util.Arrays;


// 做前没有任何思路
// 做后， 排序+two pointers 太屌了
public class LeetCode259_medium_3SumSmaller {
	
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i + 2 < nums.length; i++) {
			sum += twoSumSmaller(nums, i+1, target - nums[i]); // 只从i的右边找， 右边至少要有两个数。
		}
		return sum;
	}
	
	// 找两个idx，这两个数只和小于target
	private int twoSumSmaller(int[] nums, int startIndex, int target) {
		int sum = 0;
		int left = startIndex;
		int right = nums.length-1;
		
		while (left < right) {
			if (nums[left] + nums[right] >= target) { // 说明包含nums[right]肯定大于target，所以right要左移动。
				right--;
			} else {
				sum += right-left;
				left++;
			}
		}
		
		return sum;
	}
}
