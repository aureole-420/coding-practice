package fall_2019.microsoft;

import java.util.*;

public class leetcode381_hard_insertDeleteGetRandom_Duplicate {

    class RandomizedCollection {

        List<Integer> nums;
        Map<Integer, Set<Integer>> locs;
        Random rand;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            nums = new ArrayList<>();
            locs = new HashMap<>();
            rand = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean ret = !locs.containsKey(val);
            nums.add(val);
            Set<Integer> set = locs.getOrDefault(val, new LinkedHashSet<>());
            set.add(nums.size()-1);
            locs.put(val, set);
            return ret;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!locs.containsKey(val)) return false;

            int idx = locs.get(val).iterator().next();

            int tailIdx = nums.size()-1;
            int tailElem = nums.get(tailIdx);
            if (tailElem != val) { // 这儿很烦人，要多写几遍。
                nums.set(idx, tailElem);
                nums.remove(tailIdx);
                locs.get(tailElem).add(idx);
                locs.get(tailElem).remove(tailIdx);
                locs.get(val).remove(idx);
            } else {
                // if tailElem == val, then remove tail directly.
                nums.remove(tailIdx);
                locs.get(val).remove(tailIdx);
            }
            if (locs.get(val).size() == 0) {
                locs.remove(val);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            if (nums.size() == 0) return -1;
            return nums.get(rand.nextInt(nums.size()));
        }
    }
}
