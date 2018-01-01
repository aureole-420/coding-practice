package algorithm_ladder_V;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm_ladder_IV.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	
	private int N = 0; // number of nodes in current layer
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		N = 1;
		List<Integer> layer = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			layer.add(cur.val);
			N--;
			
			if (cur.left != null) queue.offer(cur.left);
			if (cur.right != null) queue.offer(cur.right);
			
			if (N == 0) {
				res.add(new ArrayList<Integer>(layer));
				layer.clear();
				N = queue.size();
			}
		}
        return res;
    }
	
	public void printList(List<Integer> list) {
		for (int i : list) 
			System.out.print(i + " ");
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.left = new TreeNode(4);
		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> r = b.levelOrder(root);
		for (List<Integer> list : r)  // should be [1] [4,2] [3]
			b.printList(list);
	}
}
