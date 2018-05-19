package algorithm_ladder_IV;

/*
 * leetcode 235
 * Binary Search Tree
 */
public class Redo_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
        		if (p.val > root.val && q.val > root.val) {
        			root = root.right;
        		} else if (p.val < root.val && q.val < root.val) {
        			root = root.left;
        		} else if (root.val == p.val || root.val == q.val) {
        			return root;
        		} else {
        			return root;
        		}
        }
        
        return null;
    }
    
    public static void main(String[] args) {
    		TreeNode root = new TreeNode(6);
    		root.left = new TreeNode(5);
    		root.right = new TreeNode(8);
    		root.left.left = new TreeNode(0);
    		root.left.right = new TreeNode(4);
    }
}
