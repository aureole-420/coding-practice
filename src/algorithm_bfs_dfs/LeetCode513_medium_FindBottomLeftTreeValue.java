package algorithm_bfs_dfs;

// leftmost value in the last row of the tree
// 1. 必然在最后一行，左右子数哪一颗更深，必然就在哪一边
public class LeetCode513_medium_FindBottomLeftTreeValue {
	class ResultType {
		int height;
		int leftMost;
		ResultType (int h, int l) {
			height = h;
			leftMost = l;
		}
	}
	
	
    public int findBottomLeftValue(TreeNode root) {
        ResultType res = find(root);
        return res.leftMost;
    }
    
    private ResultType find(TreeNode root) {
    		if (root == null) {
    			return new ResultType(0, 0);
    		}
    		
    		ResultType lRes = find(root.left);
    		ResultType rRes = find(root.right);
    		
    		int newHeight = Math.max(lRes.height, rRes.height) + 1;
    		if (newHeight == 1) { // if leaf
    			return new ResultType(1, root.val);
    		}
    		
    		int newLeftMost;
    		if (rRes.height > lRes.height) {
    			newLeftMost = rRes.leftMost;
    		} else {
    			newLeftMost = lRes.leftMost;
    		}
    		
    		return new ResultType(newHeight, newLeftMost);
    }
    
    
}
