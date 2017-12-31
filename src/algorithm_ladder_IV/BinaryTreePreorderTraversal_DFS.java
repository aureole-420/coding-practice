package algorithm_ladder_IV;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_DFS {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        return list;
    }
	
	private void dfs(TreeNode root, List<Integer> list) {
		if (root == null) return;
		
		list.add(root.val);
		dfs(root.left, list);
		dfs(root.right, list);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.left = new TreeNode(4);
		BinaryTreePreorderTraversal_DFS b = new BinaryTreePreorderTraversal_DFS();
		List<Integer> list = b.preorderTraversal(root);
		for (int i : list) System.out.print(i + " "); // should be 1,4,2,3
	}
}
