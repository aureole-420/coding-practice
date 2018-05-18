package algorithm_ladder_III.normal_binary_tree;

/*
 * 简单的方法是直接返回高度，非balanced返回-1高度。
 */
public class Redo_BalancedBinaryTree {
	
	class ResultType{
		int depth;
		boolean is_balanced;
		ResultType (int d, boolean ib) {
			this.depth = d;
			this.is_balanced = ib;
		}
	}
	
    public boolean isBalanced(TreeNode root) {
        ResultType r = checkBalance(root);
        return r.is_balanced;
    }
    
    public ResultType checkBalance(TreeNode root) {
    		// base case:
    		if (root == null) {
    			return new ResultType(0, true);
    		}
    		
    		// divide and conquer
    		ResultType left = checkBalance(root.left);
    		ResultType right = checkBalance(root.right);
    		
    		if (!left.is_balanced || !right.is_balanced) {
    			return new ResultType(0, false);
    		}
    		
    		if (Math.abs(left.depth - right.depth) > 1) {
    			return new ResultType(0, false);
    		} else {
    			return new ResultType(Math.max(left.depth, right.depth)+1, true);
    		}
    }
    
    public static void main(String[] args) {
    	
    		TreeNode root1 = new TreeNode(1);
    		root1.left = new TreeNode(2);
    		root1.right = new TreeNode(2);
    		root1.left.left = new TreeNode(3);
    		root1.left.right = new TreeNode(3);
    		root1.left.left.left = new TreeNode(4);
    		root1.left.left.right = new TreeNode(4);
    		
    		TreeNode root2 = new TreeNode(1);
    		root2.left = new TreeNode(2);
    		root2.right = new TreeNode(2);
    		root2.right.left = new TreeNode(15);
    		root2.right.right = new TreeNode(7);
    		
    		Redo_BalancedBinaryTree bbt = new Redo_BalancedBinaryTree();
    		System.out.println(bbt.isBalanced(root1)); // should be false
    		System.out.println(bbt.isBalanced(root2)); // should be true
    }
}
