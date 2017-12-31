package algorithm_ladder_IV;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * leetcode 145
 */
public class BinaryTreePostorderTraversal_Iteration {
	/*
	public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        LinkedList<Integer> res = new LinkedList<Integer>();
        
        if (root == null) return res;
        
        stack.push(root);
        while (!stack.isEmpty()) {
        		TreeNode cur = stack.pop();
        		res.addFirst(cur.val);
        		if (cur.left != null) stack.push(cur.left);
        		if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }
    */
	public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        dfs(root, res);
        return res;
	} 
	private void dfs(TreeNode root, LinkedList<Integer> res) {
		if (root == null) return;
		dfs(root.left, res);
		dfs(root.right, res);
		res.add(root.val);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.left = new TreeNode(4);
		BinaryTreePostorderTraversal_Iteration b = new BinaryTreePostorderTraversal_Iteration();
		List<Integer> list = b.postorderTraversal(root);
		for (int i : list) System.out.print(i + " "); // should be 4321
	}
}
