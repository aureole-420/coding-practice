package algorithm_ladder_IV;

// 注意：这里交叉迭代。
// TP(root) = T(root) + TP(left) + TP(right); => TP(root) = sum(# nodes in subtree) over all nodes; => O(nlog(n))
// T(root) = T(left) + T(right) + 1;  =>T(root) = O(# nodes)
public class Redo_PathSum_III {
    public int pathSum(TreeNode root, int sum) {
        //base case:
    		if (root == null) {
    			return 0;
    		}
    		
    		return pathSumFromCrntNode(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    // num of from current nodes;
    private int pathSumFromCrntNode(TreeNode root, int sum) {
    		// base case:
    		if (root == null) {
    			return 0;
    		}
    		
    		int result = 0;
    		if (root.val == sum) {
    			result = 1;
    		}
    		
    		int leftNumPath = pathSumFromCrntNode(root.left, sum-root.val);
    		int rightNumPath = pathSumFromCrntNode(root.right, sum-root.val);
    		return result + leftNumPath + rightNumPath;  		
    }
    
    public static void main(String[] args) {
    		TreeNode root = new TreeNode(10);
    		root.left = new TreeNode(5);
    		root.right = new TreeNode(-3);
    		root.left.left = new TreeNode(3);
    		root.left.right = new TreeNode(2);
    		root.left.left.left = new TreeNode(3);
    		root.left.left.right = new TreeNode(-2);
    		root.left.right.right = new TreeNode(1);
    		root.right.right = new TreeNode(11);
    		
    		Redo_PathSum_III ps = new Redo_PathSum_III();
    		System.out.println(ps.pathSum(root, 8)); // should be 3
    }
}
