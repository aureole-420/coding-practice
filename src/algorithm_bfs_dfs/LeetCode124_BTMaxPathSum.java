package algorithm_bfs_dfs;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// hard， 典型的分治
// 每个节点返回：到该节点的maxPathSum
public class LeetCode124_BTMaxPathSum {
//	
	class ResultType{
		int maxVal;
		ResultType(int val) {
			this.maxVal = val;
		}
	}
	
    public int maxPathSum(TreeNode root) {
    		ResultType res = new ResultType(Integer.MIN_VALUE);
        checkPathSum(root, res);
        
        return res.maxVal;
    }
    
    // return the max path sum Starting from current node
    private int checkPathSum(TreeNode root, ResultType res) {
    		if (root == null) {
    			return Integer.MIN_VALUE;
    		}
    		
    		int left = checkPathSum(root.left, res);
    		int right = checkPathSum(root.right, res);
    		
    		int maxSub = Math.max(left, right);  		
    		int curVal = maxSub > 0 ? maxSub+root.val : root.val;
    		
    		// check possible sequence 需要比较的东西比较多！
    		int temp = Math.max(0, left) + Math.max(0,  right) + root.val; 
    		if (temp > res.maxVal) {
    			res.maxVal = temp;
    		}

    		
    		return curVal;
    }
}
