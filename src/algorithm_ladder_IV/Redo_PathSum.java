package algorithm_ladder_IV;


// 分治法
// 注意base case，此题一定要到leaf节点结束才行！
public class Redo_PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		// corner case:
		if (root == null) {
			return false;
		}
		
		return dfs(root, sum);
	}
	
	private boolean dfs(TreeNode root, int sum) {
		// base case
		if (root == null) {
			return false;
		}
		
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		
		return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);	
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		Redo_PathSum rps = new Redo_PathSum();
		System.out.println(rps.hasPathSum(root, 1));
		
	}
}
