package algorithm_twoPointers;

// 做前：没想法
// 做中，看了一下followup 分类问题，用redix sort, count number of every elem, and put them ...
// 
// 要求用one pass
// solution 1. 双指针，0放左，2放右，1自然就到中间了
// 
// solution 2. 
// 3个指针？哇，三指针那个好屌，太厉害了！
// https://leetcode.com/problems/sort-colors/discuss/26500/Four-different-solutions
public class LeetCode75_medium_SortColors {
    public void sortColors(int[] nums) {
    		int n0 = -1, n1 = -1, n2 = -1;
    		// 一定是n0 <= n1 <= n2,因为0，1，2 放 左中右
    	
    		for (int i = 0; i < nums.length; i++) {
    			if (nums[i] == 0) { //要插入一个0， 那么n1, n2 都要向右平移一格，
    				nums[++n2] = 2;
    				nums[++n1] = 1;
    				nums[++n0] = 0;
    			} else if (nums[i] == 1) { // insert 1， only n2 要向右平移
    				nums[++n2] = 2;
    				nums[++n1] = 1;
    			} else if (nums[i] == 2) {
    				nums[++n2] = 2;
    			}
    		}
    }

}
