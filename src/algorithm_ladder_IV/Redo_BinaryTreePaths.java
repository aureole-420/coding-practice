package algorithm_ladder_IV;

import java.util.LinkedList;
import java.util.List;

// dfs search tree
/*
 * 想得太复杂了，分治的思想就是
 * 想要的结果A
 * A = func(left_A, right_A)
 */
public class Redo_BinaryTreePaths {
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new LinkedList<String>();
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(root.val);
		dfs(root, list, result);
		
		return result;
	}
	
	private void dfs(TreeNode root, List<Integer> list, List<String> result) {
		// base case:
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			// list to string; add string to result
			result.add(listToString(list));
		}
		
		// otherwise dfs its children
		if (root.left != null) {
			list.add(root.left.val);
			dfs(root.left, list, result);
			list.remove(list.size()-1);
		}
		if (root.right != null) {
			list.add(root.right.val);
			dfs(root.right, list, result);
			list.remove(list.size()-1);
		}
		
	}
	
	private String listToString(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				sb.append(Integer.toString(list.get(i)));
			} else {
				sb.append("->" + Integer.toString(list.get(i)));
			}
		}
		return sb.toString();
	}
}
