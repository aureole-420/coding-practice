package algorithm_ladder_IV;

public class MinimumSubtree {
	
	private int MinSum = Integer.MAX_VALUE;
	private TreeNode ResNode = null;
	
	public TreeNode findSubtree(TreeNode root) {
		calSum(root);
		return ResNode;
	}
	
	private int calSum(TreeNode root) {
		if (root == null) return 0;
		
		// not null
		int left = calSum(root.left);
		int right = calSum(root.right);
		int newSum = left + right + root.val;
		if (newSum < MinSum) {
			MinSum = newSum;
			ResNode = root;
		}
		return newSum;
	}
}
