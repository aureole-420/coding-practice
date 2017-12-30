package algorithm_ladder_IV;

public class ValidateBinarySearchTree {
	class ResultType{
		long MinInBST;
		long MaxInBST;
		boolean isBST;
		ResultType(long minInBST, long maxInBST, boolean isBST) {
			super();
			MinInBST = minInBST;
			MaxInBST = maxInBST;
			this.isBST = isBST;
		}
	}
	
	public boolean isValidBST(TreeNode root) {
		ResultType r = checkBST(root);
		return r.isBST;
    }
	
	private ResultType checkBST(TreeNode root) {
		if (root == null) 
			return new ResultType(Long.MAX_VALUE, Long.MIN_VALUE, true);
		
		// 不需要讨论root是否是leaf
		ResultType ltree = checkBST(root.left);
		if (!ltree.isBST) 
			return new ResultType(Long.MAX_VALUE, Long.MIN_VALUE, false);
		
		ResultType rtree = checkBST(root.right);
		if (!rtree.isBST) 
			return new ResultType(Long.MAX_VALUE, Long.MIN_VALUE, false);
		
		// both ltree and rtree are bst
		if (ltree.MaxInBST < root.val && root.val < rtree.MinInBST) 
			// 注意左右子树为null的情况。
			return new ResultType(Math.min(ltree.MinInBST, root.val), Math.max(root.val, rtree.MaxInBST), true);
		else 
			return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE, false);
	}	
}
