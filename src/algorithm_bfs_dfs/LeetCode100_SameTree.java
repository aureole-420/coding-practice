package algorithm_bfs_dfs;

import algorithm_graph_I.TreeNode;

// 简单的递归
// O(n),最多把树遍历一遍。
public class LeetCode100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
    		if (p == null && q == null) {
    			return true;
    		}
    		
    		if (p!= null && q!=null) {
    			if (p.val == q.val)  {
    				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    			}
    		}
    		
    		return false;
    }
}
