package algorithm_ladder_III.normal_binary_tree;

/**
 * leetcode 110
 * 通过求深度来求判断是否是balanced
 */
public class BalancedBinaryTree {
	class ResultType {
		int depth;
		boolean isBalanced;
		ResultType(int depth, boolean isBalanced) {
			this.depth = depth;
			this.isBalanced = isBalanced;
		}
	}
	
	public boolean isBalanced(TreeNode root) {
		ResultType res = checkHeightAndBalance(root);
		return res.isBalanced;
    }
	
	private ResultType checkHeightAndBalance(TreeNode root) {
		if (root == null) return new ResultType(0, true);
		
		ResultType left = checkHeightAndBalance(root.left);
		ResultType right = checkHeightAndBalance(root.right);
		int newDepth = 1+ Math.max(left.depth, right.depth);
		boolean newIsBalanced = left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) <= 1;
		return new ResultType(newDepth, newIsBalanced);
	}
}
