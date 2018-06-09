package algorithm_bfs_dfs;

import java.util.*;
// 这题真得很经典
// https://leetcode.com/problems/symmetric-tree/submissions/1
// 两种做法， recursive和iterative
public class LeetCode101_SymTree {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//        		return true;
//        }
//        
//        return isSymmetric(root.left, root.right);
//    }
    
    // iterative的方法
	// maintain两个queue，分别用两种方式bfs traversal tree，
	// 方式一： 先左子树后右子树
	// 方式2: 先右子树再左子树，
	//每一步的值应该相等。
    public boolean isSymmetric(TreeNode root) {
    		if(root == null) {
    			return true;
    		}
    		
    		Queue<TreeNode> queue1 = new LinkedList<>();
    		Queue<TreeNode> queue2 = new LinkedList<>();
    		
    		queue1.offer(root);
    		queue2.offer(root);
    		int numOfCurLayer1 = 1;
    		int numOfCurLayer2 = 1;
    		
    		while (!queue1.isEmpty() && !queue2.isEmpty()) {
    			if (numOfCurLayer1 == 0) {
    				if (numOfCurLayer2 != 0) {
    					return false;
    				}
    				numOfCurLayer1 = queue1.size();
    				numOfCurLayer2 = queue2.size();
    			}
    			
    			TreeNode cur1 = queue1.poll();
    			TreeNode cur2 = queue2.poll();
    			numOfCurLayer1--;
    			numOfCurLayer2--;
    
    			
    			if (cur1.val != cur2.val) {
    				return false;
    			}
    			
    			if (cur1.left != null) {
    				if (cur2.right == null) {
    					return false;
    				}
    				queue1.offer(cur1.left);
    				queue2.offer(cur2.right);
    			}
    			
    			if (cur1.right != null) {
    				if (cur2.left == null) {
    					return false;
    				}
    				queue1.offer(cur1.right);
    				queue2.offer(cur2.left);
    			}
    		}
    		
    		return true;
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
    		if (left == null && right == null) {
    			return true;
    		}
    		
    		if (left == null || right == null) {
    			return false;
    		}
    		
    		if (left.val == right.val) {
    			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    		}
    		
    		return false;
    }
}
