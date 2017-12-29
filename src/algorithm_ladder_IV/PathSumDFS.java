package algorithm_ladder_IV;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Leetcode 112, alternative solution using dfs
 */
public class PathSumDFS {
	
	private List<List<Integer>> res;
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		res = new ArrayList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		dfs(root, list, sum);
		return res;
	}
	
	private void dfs(TreeNode root, List<Integer> list, int sum) {
		if (root == null) return;
		
		list.add(root.val);
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				res.add(new ArrayList<Integer>(list));
			}
		} else {
			dfs(root.left, list, sum-root.val);
			dfs(root.right, list, sum-root.val);
		}
		list.remove(list.size()-1);
	}

}
