package algorithm_tree;

public class LeetCode270_medium_ClosestBSTValue {
	
    public int closestValue(TreeNode root, double target) {
        if (Math.abs(target - root.val) < 1e-6) {
        		return root.val;
        } else if (target < root.val) {
        		if (root.left == null) {
        			return root.val;
        		} else {
        			int potential = closestValue(root.left, target);
        			return Math.abs(target - root.val) <= Math.abs(target-potential) ? root.val : potential;
        		}
        } else {
        		if (root.right == null) {
        			return root.val;
        		} else {
        			int potential = closestValue(root.right, target);
        			return Math.abs(target - root.val) <= Math.abs(target-potential) ? root.val : potential;
        		}
        }
    }
}
