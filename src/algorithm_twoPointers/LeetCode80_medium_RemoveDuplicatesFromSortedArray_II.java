package algorithm_twoPointers;

// 这题比较简单，就是maintain start end ptr来记录重复元素的起始/终止位置。
public class LeetCode80_medium_RemoveDuplicatesFromSortedArray_II {
	
    public int removeDuplicates(int[] nums) {
        int curValue = 0;
        int start = 0, end = 0;
        
        for (int idx = 0; idx < nums.length; idx++) {
        		if (idx == 0) {
        			curValue = nums[0]; // initialize curValue
        			start = 0; end = 0;
        			continue;
        		}
        		
        		if (nums[idx] != curValue) {
        			curValue = nums[idx];
        			nums[end+1] = nums[idx];
        			start = end+1;
        			end = end+1;
        			continue;
        		}
        		
        		// nums[idx] == curValue
        		if (end-start == 1) { // already two repeated number
        			continue; // idx++
        		}
        		
        		end = end+1;
        		nums[end] = curValue;
        }
        
        return end+1;
    }
}
