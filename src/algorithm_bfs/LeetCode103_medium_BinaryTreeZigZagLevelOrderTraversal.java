package algorithm_bfs;

import java.util.*;


// 做前，只想到了bfs traversal后reverse
// 做中： 看了最高票答案， 
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/33815/My-accepted-JAVA-solution
// 发现dfs做确实挺好的，奇数层addFirst， 偶数层addLast
// 用bfs做也挺简单的。
public class LeetCode103_medium_BinaryTreeZigZagLevelOrderTraversal {
	
	// dfs solution
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(root, 0, result);
		
		return result;
	}
	
	// 偶数level： 从左往右， addLast
	// 奇数level：从右往左： addFirst
	private void dfs(TreeNode root, int level, List<List<Integer>> result) {
		if (root == null) {
			return;
		}
		
		if (level+1 > result.size()) {
			result.add(new LinkedList<>());
		}
		
		if (level % 2 == 0) {
			result.get(level).add(root.val);
		} else {
			result.get(level).add(0, root.val);
		}
		
		dfs(root.left, level+1, result);
		dfs(root.right, level+1, result);		
	}
	
//	// bfs solution
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        
//        if (root == null) {
//        		return result;
//        }
//        
//        Queue<TreeNode> queue = new LinkedList<>();
//        
//        int numOfCurLevel = 1;
//        queue.offer(root);
//        result.add(new LinkedList<Integer>());
//        boolean order = true; // true: left to right(addLast); false: right to left(addFirst)
//        
//        while (!queue.isEmpty()) {
//        		if (numOfCurLevel == 0) {
//        			numOfCurLevel = queue.size();
//        			result.add(new LinkedList<Integer>());
//        			order = !order;
//        		}
//        		
//        		TreeNode cur = queue.poll();
//        		if (order) {
//        			result.get(result.size()-1).add(cur.val);
//        		} else {
//        			result.get(result.size()-1).add(0, cur.val);
//        		}
//        		
//        		numOfCurLevel--;
//        		if (cur.left != null) queue.offer(cur.left);
//        		if (cur.right != null) queue.offer(cur.right);
//        }
//        
//        return result;
//    }
}
