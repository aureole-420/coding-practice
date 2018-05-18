package algorithm_ladder_IV;

public class Redo_MaxDepthBST {
	public int maxDepth(TreeNode root) {
		//base case
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;	
	}
}
