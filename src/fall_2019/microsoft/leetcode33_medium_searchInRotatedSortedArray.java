package fall_2019.microsoft;

public class leetcode33_medium_searchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0, hi = nums.length-1;
        while (lo + 1 < hi) {
            int mid = lo + (hi -lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[lo]) {
                // lo -> mid increasing
                if (nums[lo] <= target && target <= nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                // mid -> hi increasing
                if (nums[mid] <= target && target <= nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }

        if (target == nums[lo]) return lo;
        if (target == nums[hi]) return hi;
        return -1;
    }
}
