package algorithm_ladder_IV;


// leetcode 654, 还挺好的一道题，解法适
// worst case O(n^2)
public class MaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildMBT(nums, 0, nums.length-1);
    }
    
    private TreeNode buildMBT(int[] nums, int startIdx, int endIdx) {
    		if (startIdx < 0 || endIdx >= nums.length || endIdx < startIdx) {
    			return null;
    		}
    		
    		int maxIdx = findMax(nums, startIdx, endIdx);
    		TreeNode left = buildMBT(nums, startIdx, maxIdx-1);
    		TreeNode right = buildMBT(nums, maxIdx+1, endIdx);
    		
    		TreeNode root = new TreeNode(nums[maxIdx]);
    		root.left =left;
    		root.right = right;
    		
    		return root;
    }
    
    // O(n) to find max  -- 据说用segment tree效率很高
    private int findMax(int[] nums, int startIdx, int endIdx) {
    		int maxIdx = startIdx;
    		for (int i = startIdx; i <= endIdx; i++) {
    			if (nums[i] > nums[maxIdx]) {
    				maxIdx = i;
    			}
    		}
    		
    		return maxIdx;
    }
}
