package algorithm_ladder_IV;

// 返回两个节点， 1。 subtree的root 2. subtree的最右边节点
public class Redo_FlattenBinaryTree2LinkedList {
	
	class ResultType {
		TreeNode front;
		TreeNode tail;
		ResultType(TreeNode f, TreeNode t) {
			front = f;
			tail = t;
		}
	}
	
	public void flatten(TreeNode root) {
		ResultType res = flattenTree(root);
	}
	
	private ResultType flattenTree(TreeNode root) {
		// Corner case RATHER THAN base case;
		if (root == null) {
			return new ResultType(null, null);
		}
		
		if (root.left == null && root.right == null) { // is leaf
			return new ResultType(root, root);
		}
		
		ResultType left = flattenTree(root.left);
		ResultType right = flattenTree(root.right);
		
		TreeNode rightTail;
		if (root.left == null) { // left subtree is null
			root.right = right.front;
			rightTail = right.tail;
		} else if (root.right == null) { // right subtree is null
			root.right = left.front;
			root.left = null;
			rightTail = left.tail;
		} else { // neither left/right subtrees are null
			root.right = left.front;
			root.left = null;
			left.tail.right = right.front;
			rightTail = right.tail;
		}	
		return new ResultType(root, rightTail);
	}
	
	public void printLinkedList(TreeNode root) {
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.right;
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		
		Redo_FlattenBinaryTree2LinkedList fbt = new Redo_FlattenBinaryTree2LinkedList();
		fbt.flatten(root);
		
		fbt.printLinkedList(root);
	}

}
