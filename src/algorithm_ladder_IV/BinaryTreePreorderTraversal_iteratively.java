package algorithm_ladder_IV;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Leetcode 114
 * 非递归需要用到queue?
 */
public class BinaryTreePreorderTraversal_iteratively {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(); 
        if (root == null) return res;
        
        stack.push(root);
        while (!stack.isEmpty()) {
        		TreeNode cur = stack.pop();
        		res.add(cur.val);
        		if (cur.right != null) stack.push(cur.right);
        		if (cur.left != null) stack.push(cur.left);
        }
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.left = new TreeNode(4);
		BinaryTreePreorderTraversal_iteratively b = new BinaryTreePreorderTraversal_iteratively();
		List<Integer> list = b.preorderTraversal(root);
		for (int i : list) System.out.print(i + " "); // should be 1,4,2,3
	}
}
