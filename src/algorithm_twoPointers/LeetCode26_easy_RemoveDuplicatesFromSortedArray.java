package algorithm_twoPointers;

// 做前：完全不知道怎么做

// 做中:没看答案，但是考虑到这题是twopointers，于是用桑哥pointer记录，
// pointer l: 当前不重复元素的个数
// pointer s： 当前重复元素序列的start
// pointer s： 当前重复元素序列的end；
// 不断更新
public class LeetCode26_easy_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = 0; // length of unduplicated chars
        int s = 0; // start of duplicates
        int e = 0; // end of duplicates
        
        while (e < nums.length) {
        		// e reach end of duplicates
        		if (e+1 >= nums.length || nums[e+1] != nums[e]) {
        			// 重复元素到头了，把不重复的元素记录到前面
        			nums[l] = nums[s];
        			
        			// 更新pointers
        			l++;
        			e++;
        			s = e;
        		} else { // 重复元素。
        			e++;
        		}
        }
        
        return l;
    }
    
    
}
