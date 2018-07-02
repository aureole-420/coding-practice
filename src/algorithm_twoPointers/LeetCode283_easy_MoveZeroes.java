package algorithm_twoPointers;

// 做前：要求：1. in-place 2. minimize # of operations.
// 做中： 用了两个pointers，依次改写

// 做后：我做的只是space optimal，O(1), operation我做了O(n)次
// 而且连次最优都不算我可能改写了O(2n), 可以只移动不改写后面的，最后一次改写

// https://leetcode.com/problems/move-zeroes/solution/
// 诶，似乎我做的就是optimal？只做了num of non-0 elements次操作。worst case 依然O(n)

public class LeetCode283_easy_MoveZeroes {
    public void moveZeroes(int[] nums) {
    		if (nums == null) {
    			return;
    		}
    		
        int nxtOpPos = 0, nxtIdx2Ck = 0;
        while (nxtIdx2Ck < nums.length) {
        		if (nums[nxtIdx2Ck] != 0) {
        			if (nxtIdx2Ck != nxtOpPos) {
        				nums[nxtOpPos] = nums[nxtIdx2Ck];
        				nums[nxtIdx2Ck] = 0;
        			}
        			nxtOpPos++;
        			nxtIdx2Ck++;
        		} else {
        			nxtIdx2Ck++;
        		}
        		
        }
    }
}
