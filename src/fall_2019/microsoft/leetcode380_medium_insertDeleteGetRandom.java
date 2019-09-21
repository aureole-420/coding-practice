package fall_2019.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class leetcode380_medium_insertDeleteGetRandom {

    class RandomizedSet {

        ArrayList<Integer> nums;
        HashMap<Integer, Integer> num2Idx;
        Random random;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<>();
            num2Idx = new HashMap<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (num2Idx.containsKey(val)) {
                return false;
            }

            nums.add(val);
            num2Idx.put(val, nums.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!num2Idx.containsKey(val))
                return false;
            int idx = num2Idx.get(val);
            if (idx < nums.size() - 1) { // 交换target元素和最后一个元素
                int tailElem = nums.get(nums.size()-1);
                num2Idx.put(tailElem, idx);
                nums.set(idx, tailElem);
            }

            nums.remove( nums.size()-1);
            num2Idx.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
