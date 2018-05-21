package algorithm_ladder_IV;

public class Redo_ValidateBinarySearchTree {
	
	class ResultType {
		boolean bST;
//		int maxElem;
//		int minElem;
		long maxElem;
		long minElem;
		ResultType (boolean b, long max, long min) {
			bST = b;
			maxElem = max;
			minElem = min;
		}
	}
	
    public boolean isValidBST(TreeNode root) {
        ResultType rs = checkBST(root);
        return rs.bST;
    }
    
    private ResultType checkBST(TreeNode root) {
    		// base case:
    		if (root == null) {
    			return new ResultType(true, Long.MIN_VALUE, Long.MAX_VALUE);
    		}
    		
    		ResultType l = checkBST(root.left);
    		ResultType r = checkBST(root.right);
    		
    		if (!l.bST || !r.bST) { // if left or right subtree is not BST
    			return new ResultType(false, 0, 0);
    		}
    		
    		if (l.maxElem >= root.val || r.minElem <= root.val) { // left subtree has element greater than root.val, or right ....
    			return new ResultType(false, 0, 0);
    		}
    		
    		return new ResultType(true, Math.max(root.val, r.maxElem), Math.min(root.val, l.minElem));
    }
    
    
}
