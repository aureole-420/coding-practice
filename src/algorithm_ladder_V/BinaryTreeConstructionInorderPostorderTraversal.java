package algorithm_ladder_V;

public class BinaryTreeConstructionInorderPostorderTraversal {
	private int curPostIndex;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        curPostIndex = postorder.length-1;
        return buildTree(inorder, postorder, 0, inorder.length-1);
    }
	
	/*
	 * 这题跟其他重建BT的题也有点像，每次只重建一个node！然后递归重建该节点的左右children
	 */
	private TreeNode buildTree(int[] in, int[] post, int inStart, int inEnd) {
		if (inStart > inEnd) return null;
		
		TreeNode root = new TreeNode(post[curPostIndex--]);	
		int curInIndex = inIndex(in, post[curPostIndex+1], inStart, inEnd);
		//一定要先right tree!!!!
		root.right = buildTree(in, post, curInIndex+1, inEnd);
		root.left = buildTree(in, post, inStart, curInIndex-1);
		return root;
	}
		
	// assume target always present in array
	private int inIndex(int[] in, int target, int inStart, int inEnd) {
		int i = 0;
		for (i = inStart; i <= inEnd; i++) {
			if (in[i] == target)
				break;
		}
		return i;
	}

	public static void main(String[] args) {
		BinaryTreeConstructionInorderPostorderTraversal b = new BinaryTreeConstructionInorderPostorderTraversal();
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.right = new TreeNode(3);
//		root.right = new TreeNode(4);
		int[] in = new int[] {2,3,1,4};
		int[] post = new int[] {3,2,4,1};
		TreeNode root = b.buildTree(in, post);
		System.out.println(root.left.right.val); // should be 3;
	}
	
	
}
