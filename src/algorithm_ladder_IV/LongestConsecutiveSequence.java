package algorithm_ladder_IV;

public class LongestConsecutiveSequence {
	
	private int LCS = 0;
	public int longestConsecutive(TreeNode root) {
		currentLC(root);
        return LCS;
    }
	
	// returns the length of from root node
	private int currentLC(TreeNode root) {
		if (root == null) return 0;
		int leftLC = currentLC(root.left);
		int rightLC = currentLC(root.right);
		
		if (leftLC == 0) // root.left == null
			leftLC = 1;
		else { // root.left != null
			if (root.val + 1 == root.left.val) 
				leftLC++;
			else 
				leftLC = 1;
		}
		
		if (rightLC == 0) rightLC = 1;
		else {
			if (root.val+1 == root.right.val)
				rightLC++;
			else 
				rightLC = 1;
		}
		
		int currentLCS = Math.max(leftLC, rightLC);
		if (currentLCS > LCS) 
			LCS = currentLCS;
		return currentLCS;
	}
}
