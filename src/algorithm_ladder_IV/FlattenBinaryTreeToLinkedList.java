package algorithm_ladder_IV;

public class FlattenBinaryTreeToLinkedList {
	class ResultType {
		TreeNode head;
		TreeNode tail;
		ResultType(TreeNode head, TreeNode tail) {
			this.head = head;
			this.tail = tail;
		}
	}
		
	public void flatten(TreeNode root) {
       flattenHelper(root);
    }
	
	private ResultType flattenHelper(TreeNode root) {
		if (root == null) return new ResultType(null, null);
		
		if (root.left == null && root.right == null)  // leaf
			return new ResultType(root, root);
		
		// non-leaf node
		ResultType left = flattenHelper(root.left);
		ResultType right = flattenHelper(root.right);
		if (left.head == null) { // left subtree is null
			root.left = null;
			root.right = right.head;
			return new ResultType(root, right.tail); // right cannot be null
		} else { 				// left subtree is non-null
			root.left = null; 
			root.right = left.head;
			left.tail.right = right.head;
			TreeNode newTail = right.head == null ? left.tail : right.tail;
			return new ResultType(root, newTail);
		}
	}
}
