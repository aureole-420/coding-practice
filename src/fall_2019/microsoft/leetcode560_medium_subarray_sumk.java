package fall_2019.microsoft;

import java.util.HashMap;

public class leetcode560_medium_subarray_sumk {
    public int subarraySum(int[] nums, int k) {
        int N = nums.length;
        HashMap<Integer, Integer> sum2count = new HashMap<>();
        sum2count.put(0, 1); // this is important
        int sum = 0, totalCount = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            if (sum2count.containsKey(sum - k)) { // try to find sum[i] = sum - k
                totalCount += sum2count.get(sum-k);
            }

            sum2count.put(sum, sum2count.getOrDefault(sum, 0) + 1);
        }
        return totalCount;
    }
}
