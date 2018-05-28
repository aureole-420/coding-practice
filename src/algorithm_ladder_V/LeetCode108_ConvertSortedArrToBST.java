package algorithm_ladder_V;


// leetcode 108
// T(root) = 1 + T(left) + T(right)
// idealy O(n)
public class LeetCode108_ConvertSortedArrToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
    		if (nums == null || nums.length == 0) {
    			return null;
    		}
    		
    		return buildBST(nums, 0, nums.length-1);
    }
    
    private TreeNode buildBST(int[] nums, int start, int end) {
    		if (start > end) {
    			return null;
    		}
    		
    		int mid = start + (end-start) / 2;
    		TreeNode root = new TreeNode(nums[mid]);
    		root.left = buildBST(nums, start, mid-1);
    		root.right = buildBST(nums, mid+1, end);
    		
    		return root;
    }
}
