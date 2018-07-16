package algorithm_HashTable;

import java.util.*;

// 做前： 这题跟hashmap本身有区别吗？

// 看了答案，仔细想了想，还是有区别的
// 1. hashmap在有skew没办法做到O(1), 
// 2. hashmap没办法做到真正的random select

// 答案的方法真的很巧妙，用hashmap存储位置，用arraylist真正的存数据。

// I got a similar question for my phone interview. The difference is that the duplicated number is allowed. So, think that is a follow-up of this question.
//How do you modify your code to allow duplicated number?

// 如果存在duplicate，那就用HashMap<Integer, HashSet<>>, 别用 HashMap<Integer, List<>>

public class LeetCode380_medium_InsertDeleteGetRandomO1 {
	
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    Random rand;
    
    /** Initialize your data structure here. */
    public void RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    		rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) {
        		return false;
        }
        int loc = nums.size();
        locs.put(val, loc);
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
        		return false;
        }
        int loc = locs.get(val);
        // 总是要移除的元素和队尾交换位置，然后移除队尾
        if (loc < nums.size()-1) {
        		nums.set(loc, nums.get(nums.size()-1));
        		locs.put(nums.get(nums.size()-1), loc);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
