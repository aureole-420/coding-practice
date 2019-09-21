package fall_2019.microsoft;

public class leetcode81_medium_searchRotatedSortedArray_II {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int lo = 0, hi = nums.length-1;
        while (lo+1 < hi) {
            int mid = lo + (hi-lo) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] > nums[lo]) {
                if (nums[lo] <= target && target <= nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else if (nums[mid] < nums[lo]) {
                if (nums[mid] <= target && target <= nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            } else { // nums[mid] == nums[lo]
                lo++;
            }
        }
        if (target == nums[lo] || target == nums[hi]) return true;
        return false;
    }
}
