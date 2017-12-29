package algorithm_ladder_III.normal_binary_tree;

/**
 * Alternative solution to leetcode 110
 */
public class BalancedBinaryTreeII {
	public boolean isBalanced(TreeNode root) {
		int r = getHeight(root);
		return r != -1;
    }
	
	public int getHeight(TreeNode root) {
		if (root == null) return 0;
		
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		
		if (left == -1 || right == -1) return -1;
		if (Math.abs(left - right) <= 1) return 1 + Math.max(left, right);
		return -1;
	}
}
