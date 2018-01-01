package algorithm_ladder_V;
import java.util.*;

public class SearchInBST {
	// return a treenode (if found) or null (not found)
//	public TreeNode search(TreeNode root, int target) {
//		if (root == null) return null;
//		
//		while (true) {
//			if (root == null) break;
//			if (root.val == target) return root;
//			if (root.val < target) root = root.right;
//			else root = root.left;
//		}
//		return root;
//	}
	
	// recursive solution
	// 左子树找不到就在右子树找。
	public TreeNode search(TreeNode root, int target) {
		if (root == null) return null;
		if (root.val == target) return root;
		else if (root.val < target)
			return search(root.right, target);
		else 
			return search(root.left, target);
	}
	
	public Iterable<TreeNode> range(TreeNode root, int lo, int hi) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		rangeHelper(root, queue, lo, hi);
		return queue;
	}
	private void rangeHelper(TreeNode node, LinkedList<TreeNode> queue, int lo, int hi) {
		if (node == null) return;
		if (lo < node.val) rangeHelper(node.left, queue, lo, hi);
		if (lo <= node.val && node.val <= hi) queue.offer(node);
		if (node.val < hi) rangeHelper(node.right, queue, lo, hi);
	}
	
	// 参考range的解法
	public TreeNode successor(TreeNode root, int target) {
		if (root == null) return null;
		
		if (target < root.val)  { //a. 左子树中没有更小的话那就是root啦！
			TreeNode temp = successor(root.left, target);
			return temp == null ? root : temp;
			}
		else if (target > root.val) { //b. 显然要在右子树中找。
			return successor(root.right, target);
		} else { //c.  target == root.val 走到这一步说明上面（a步暂时）还没找到
			// 右子树中有的话就是结果，没有的话对上层(a)判断也有用。
			return successor(root.right, target);
		} 

	}
	
	public TreeNode min(TreeNode root) {
		if (root.left == null) return root;
		else return min(root.left);
	}
	
	public TreeNode max(TreeNode root) {
		if (root.right == null) return root;
		else return max(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		
		SearchInBST s = new SearchInBST();
		TreeNode res = s.search(root, 1);
		System.out.println(res.val == 1); // true
		
		TreeNode res2 = s.search(root, 5);
		System.out.println(res2 == null); // true
		
		TreeNode t3 = s.successor(root, 1); //should be 3
		System.out.println(t3.val);
	}
}
