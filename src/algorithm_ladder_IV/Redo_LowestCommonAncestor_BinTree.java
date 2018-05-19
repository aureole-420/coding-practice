package algorithm_ladder_IV;

public class Redo_LowestCommonAncestor_BinTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
    		if (root == null) {
    			return null;
    		}
    		if (root == p || root == q) {
    			return root;
    		}
    		
    		TreeNode left = lowestCommonAncestor(root.left, p, q);
    		TreeNode right = lowestCommonAncestor(root.right, p, q);
    		if (left == null && right == null) {
    			return null;
    		} else if (left == null) {
    			return right;
    		} else if (right == null) {
    			return left;
    		} else {
    			return root;
    		}
    }
}
