package algorithm_twoPointers;

// 做前： 要求 1. do not modify array 2. O(1) space 3. less than O(n^2) complexity 4. Only one duplicate in the array
// 2怎么满足？如果排序的话 inplace sort quick sort但是改变了array。  3.的话应该是O(nlogn)那就是排序了？
// --- 不知道怎么做

// 做中：看了答案：
// 1. sort， 不满足O(1) space或者nondestructive -- O(nlogn)
// 2. set. O(n), 不满足O(1) spaxe

// 解法3太屌了！
// 充分利用了nums.length = n+1, 数字是1, ..., n
// 把nums[] 看成是一个用数组存储的list，nums[i]指向的是下一个node，那么
// nums[i] == nums[j] 表示有环存在
// 那么这题就是找环的起点，跟LeetCode142一样。
// https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
public class LeetCode287_medium_FindTheDuplicatedNumber {
    public int findDuplicate(int[] nums) {
    		if (nums.length <= 1) {
    			return -1;
    		}
    		
        int slow = nums[0] , fast = nums[nums[0]];
        while (slow != fast) {
        		slow = nums[slow];
        		fast = nums[nums[fast]];
        }
        
        int ptr = 0;
        while (ptr != slow) {
        		ptr = nums[ptr];
        		slow = nums[slow];
        }
        return ptr; // 注意不是nums[ptr]!!!!
    }
}
