package algorithm_ladder_III.normal_binary_tree;

public class Redo_SubtreeWithMaxAverage {
	
	class ResultType {
		int numNodes;
		int sum;
		ResultType(int num, int sum) {
			this.numNodes = num;
			this.sum = sum;
		}
	}
	
	private double MaxAvg = Double.NEGATIVE_INFINITY; 
	private TreeNode ResultNode = null;
	
	public TreeNode findSubtree(TreeNode root) {
		
		find(root);
//		System.out.println(ResultNode.val);
		return ResultNode;
	}
	
	private ResultType find(TreeNode root) {
		// base case:
		if (root == null) {
			return new ResultType(0, 0);
		}
		
		ResultType left = find(root.left);
		ResultType right = find(root.right);
		
		int currentNum = left.numNodes + right.numNodes + 1;
		int currentSum = left.sum + right.sum + root.val;
		
		double CurrentAvg = ((double) currentSum) / ((double) currentNum);
		if (CurrentAvg > MaxAvg) {
			MaxAvg = CurrentAvg;
			System.out.println("current node: " + root.val + " current avg: " + MaxAvg);
			ResultNode = root;
		}
		
		return new ResultType(currentNum, currentSum);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(1); left.left = new TreeNode(10); left.right = new TreeNode(15);
		TreeNode right = new TreeNode(2); right.left = new TreeNode(4); right.right = new TreeNode(5);
		root.left = left; root.right = right;
		
		Redo_SubtreeWithMaxAverage s = new Redo_SubtreeWithMaxAverage();
		
		TreeNode node = s.findSubtree(root);
//		System.out.println(root.val);
		System.out.println(node.val); // should be 1;
	}
}
