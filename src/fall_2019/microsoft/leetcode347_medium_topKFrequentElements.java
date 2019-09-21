package fall_2019.microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class leetcode347_medium_topKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> num2frequency = new HashMap<>();
        for (int num : nums) {
            num2frequency.put(num, num2frequency.getOrDefault(num, 0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1]; // freq = 0, 1, ...., N 所以 bucket[N+1]
        for (int num: num2frequency.keySet()) {
            int freq = num2frequency.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<Integer>();
            }
            bucket[freq].add(num);
        }

        List<Integer> result = new LinkedList<>();
        for (int pos = bucket.length-1; pos >= 0 && result.size() < k; pos--) {
            if (bucket[pos] != null) {
                result.addAll(bucket[pos]);
            }
        }
        return result;
    }


}
