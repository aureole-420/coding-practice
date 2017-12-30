package algorithm_ladder_IV;

public class LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) 
        		return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null)
        		return null;
        else if (left == null)
        		return right;
        else if (right == null)
        		return left;
        else
        		return root;    
    }
	
	/**
	private TreeNode LCA = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return LCA;
    }
    
    public boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
    		if (root == null) 
    			return false;
    		
    		boolean left = findLCA(root.left, p, q);
    		boolean right = findLCA(root.right, p, q);
    		
    		if (LCA != null) return true; // LCA found in subtrees
    		
    		if (!left && !right) {
    			if (root == p || root == q) return true;
    			else return false;
    		}
    		
    		if (left && right) {
    			LCA = root;
    			return true;
    		}
    		
    		if ((root == p || root == q) 
    			&& (left || right)) {
    			LCA = root;
    			return true;
    		} else 
    			return true;
    }
    */
}
