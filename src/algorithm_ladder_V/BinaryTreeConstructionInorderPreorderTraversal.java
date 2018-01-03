package algorithm_ladder_V;

public class BinaryTreeConstructionInorderPreorderTraversal {
	
	private int preIndex;
	public TreeNode buildTree(int[] inorder, int[] preorder) {
		preIndex = 0;
        return buildTree(inorder, preorder, 0, inorder.length-1);
    }
	
	
	private TreeNode buildTree(int[] inorder, int[] preorder, int inStart, int inEnd) {
		if (inStart > inEnd) return null;
		
		TreeNode root = new TreeNode(preorder[preIndex++]);
		int curInIndex = inIndex(inorder, preorder[preIndex-1], inStart, inEnd);
		// 一定要先递归构造左子树， 才能让preIndex正常++
		root.left = buildTree(inorder, preorder, inStart, curInIndex-1);
		root.right = buildTree(inorder, preorder, curInIndex+1, inEnd);
		return root;
	}
	
	
	// 假设target是存在的
	public int inIndex(int[] inorder, int target, int inStart, int inEnd) {
		int i = 0;
		for (i = inStart; i <= inEnd; i++) {
			if (inorder[i] == target) 
				break;
		}
		return i; //不考虑越界问题。
	}
	
	
	public static void main(String[] args) {
		BinaryTreeConstructionInorderPreorderTraversal b = new BinaryTreeConstructionInorderPreorderTraversal();
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.right = new TreeNode(3);
//		root.right = new TreeNode(4);
		int[] in = new int[] {2,3,1,4};
		int[] pre = new int[] {1,2,3,4};
		TreeNode root = b.buildTree(in, pre);
		System.out.println(root.left.right.val); // should be 3;
	}
}
