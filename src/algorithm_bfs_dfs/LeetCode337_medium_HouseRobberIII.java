package algorithm_bfs_dfs;

import java.util.*;

// https://leetcode.com/problems/house-robber-iii/description/
// 类似于bipartite a graph  ----- 错错错，这题并不是分色！
// 
// 这题太经典了！
// 1. 交叉recursion
// 2.有点类似DP，不是用数组，而是用map来记录！
/**
 * 正确的方式是每个节点有抢与不抢的选法
 * 如果root抢了，那子节点就必定不能抢！
 * 如果root没抢，那子节点 1. 可以抢， 2. 不能抢
 *
 */
public class LeetCode337_medium_HouseRobberIII {
	
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        
        return robSubtree(root, map);
    }
    
    private int robSubtree(TreeNode root, HashMap<TreeNode, Integer> map) {
    		if (root == null) {
    			return 0;
    		}
    		
    		if (map.containsKey(root)) {
    			return map.get(root);
    		}
    		
    		int sub = 0;
    		if (root.left != null) {
    			sub += robSubtree(root.left.left, map) + robSubtree(root.left.right, map);
    		}
    		if (root.right != null) {
    			sub += robSubtree(root.right.left, map) + robSubtree(root.right.right, map);
    		}
    		
    		int result = Math.max(root.val + sub, robSubtree(root.left, map) + robSubtree(root.right, map));
    		map.put(root, result);
    				
    		return result;
    }
	
	// 下面的答案是正确的，但超时了！
	/** 
	public int rob(TreeNode root)  {
		return Math.max(maxRobbery(root, true), maxRobbery(root, false)); 
	}
	
	// @param isRobbed Whether the root is robbed or not
	private int maxRobbery(TreeNode root, boolean isRobbed) {
		// base case
		if (root == null) {
			return 0;
		}
		
		if (isRobbed) { // root 确定被rob
			return root.val + Math.max(0, maxRobbery(root.left, false)) + Math.max(0, maxRobbery(root.right, false));
		} else { // root 确定不rob； 
			int left = Math.max(maxRobbery(root.left, true), maxRobbery(root.left, false));
			left = Math.max(0, left);
			
			int right = Math.max(maxRobbery(root.right, true), maxRobbery(root.right, false));
			right = Math.max(0, right);
			
			return left + right;
		}
	}
	*/
	
	public static void main(String[] args) {
		LeetCode337_medium_HouseRobberIII hr = new LeetCode337_medium_HouseRobberIII();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		System.out.println(hr.rob(root)); // should be 7
	}
	
	/**
	 * 下面的考虑的只是隔一间抢一个，但还有4-1-2-3这样的序列，最大的是抢4+3 = 7
	 */
//	class GroupAmount {
//		int groupOne;
//		int groupTwo;
//		GroupAmount(int one, int two) {
//			this.groupOne = one;
//			this.groupTwo = two;
//		}
//	}
//	
//    public int rob(TreeNode root) {
//    		GroupAmount ga = rob(root, true);
//    		return Math.max(ga.groupOne, ga.groupTwo);
//    }
//    
//    private GroupAmount rob(TreeNode root, boolean inGroupOne) {
//    		// base case
//    		if (root == null) {
//    			return new GroupAmount(0, 0);
//    		}
//    		
//    		GroupAmount left = rob(root.left, !inGroupOne);
//    		GroupAmount right = rob(root.right, !inGroupOne);
//    		
//    		int one = left.groupOne + right.groupOne;
//    		one = inGroupOne ? one + root.val : one;
//    		
//    		int two = left.groupTwo + right.groupTwo;
//    		two = inGroupOne ? two : two + root.val;
//    				
//    		return new GroupAmount(one, two);
//    }
}
