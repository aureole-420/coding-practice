package facebook_more;


// two pointers
public class LeetCode674_easy_LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i =0, j = 0;
        int maxLCIS = -1;
        while (true) {
            if (j+1 >= nums.length) {
                maxLCIS = Math.max(maxLCIS, j-i+1);
                break;
            } else { // j+1 still in array
                if (nums[j+1] > nums[j]) {
                    j++;
                } else {
                    maxLCIS = Math.max(maxLCIS, j-i+1);
                    j++;
                    i = j;
                }
            }
        }
        return maxLCIS;
    }

}
