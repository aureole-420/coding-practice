package algorithm_bfs_dfs;


public class LeetCode110_BalancedBinaryTree {
	
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }
    
    private int getHeight(TreeNode root) {
    		if (root == null) {
    			return 0;
    		}
    		
    		int leftHeight = getHeight(root.left);
    		int rightHeight = getHeight(root.right);
    		if (leftHeight == -1 || rightHeight == -1) { //注意这一行：分治：两边有一边不是balanced就算不balance
    			return -1;
    		}
    		
    		if (Math.abs(leftHeight-rightHeight) > 1) {
    			return -1;
    		} else {
    			return Math.max(leftHeight, rightHeight) + 1;
    		}
    		
    }
}
