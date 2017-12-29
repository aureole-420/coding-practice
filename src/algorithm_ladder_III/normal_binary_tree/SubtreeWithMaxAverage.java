package algorithm_ladder_III.normal_binary_tree;


public class SubtreeWithMaxAverage {
	class ResultType {
		int count;
		int sum;
		public ResultType(int count, int sum) {
			this.count = count;
			this.sum = sum;
		}
	}
	
	private TreeNode ResultNode = null;
	private double MaxAvg = Double.MIN_VALUE;
	public TreeNode findSubtree(TreeNode root) {
		sumAndCount(root);
		return ResultNode;
	}
	
	private ResultType sumAndCount(TreeNode root) {
		if (root == null) {
			return new ResultType(0, 0);
		}
		
		ResultType left = sumAndCount(root.left);
		ResultType right = sumAndCount(root.right);
		int newSum = left.sum + right.sum + root.val;
		int newCount = left.count + right.count + 1;
		ResultType r = new ResultType(newCount, newSum);
		if (MaxAvg < ((double) newSum / (double) newCount)) {
			MaxAvg = ((double) newSum / (double) newCount);
			ResultNode = root;
		}
		return r;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(1); left.left = new TreeNode(10); left.right = new TreeNode(15);
		TreeNode right = new TreeNode(2); right.left = new TreeNode(4); right.right = new TreeNode(5);
		root.left = left; root.right = right;
		
		SubtreeWithMaxAverage s = new SubtreeWithMaxAverage();
		
		TreeNode node = s.findSubtree(root);
		System.out.println(node.val); // should be 1;
	}
}
