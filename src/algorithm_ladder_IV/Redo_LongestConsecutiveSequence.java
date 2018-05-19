package algorithm_ladder_IV;

// leetcode 298 迭代的关键是current node的结果
public class Redo_LongestConsecutiveSequence {
	
	private int LCS = 0;
	
	public int longestConsecutive(TreeNode root) {
		lc(root);
		return LCS;
	}
	private int lc(TreeNode root) {
		// base case:
		if (root == null) {
			return 0;
		}
		
		int left = lc(root.left);
		int right = lc(root.right);
		
		int potLeft = 1, potRight = 1;
		if (root.left != null && root.val + 1 == root.left.val) {
			potLeft = left + 1;
		}
		if (root.right != null && root.val + 1 == root.right.val) {
			potRight = right + 1;
		}
		
		int cLCS = Math.max(potLeft, potRight);
		if (cLCS > LCS) {
			LCS = cLCS;
		}
		
		return cLCS;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		
		Redo_LongestConsecutiveSequence lcs = new Redo_LongestConsecutiveSequence();
		System.out.println(lcs.longestConsecutive(root)); // should be 3
	}
	
}
