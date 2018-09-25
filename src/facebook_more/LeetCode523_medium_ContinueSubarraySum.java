package facebook_more;
import java.util.*;

// 我想到了用presum, 但没想到用hashmap可以进一步优化！
public class LeetCode523_medium_ContinueSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        // <presum, index>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 非常重要
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
//                prevIdx = map.get(sum)
                // prevIdx+1, ... i, should longer than 2
                if (i > map.get(sum)) {
                    return true;
                }
            }
            map.put(sum, i);
        }

        return false;
    }

}

