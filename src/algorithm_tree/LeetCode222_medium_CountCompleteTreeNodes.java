package algorithm_tree;

// 做前：只想到O(n)的bfs， dfs解

// 做中： 1. 具体层数h可以从最左边节点得知
// 最后一层肯定是 1 ... 2^h 这些节点
// 可以binary search 1 ~ 2^h 节点


// 做后，看了答案，太屌了！！！
// 右子树的高度不可能超过左子树，所以height(root) = height(root.left) + 1
// 递归 halve the tree in every recursive step, O(log(n)) step,
// every step find height cost O(log(n))
// O(logn ^ 2)
public class LeetCode222_medium_CountCompleteTreeNodes {
	
	// 高度从0层开始算，所以null是-1. otherwise 如果leaf是一层的话，那null就是0层
	int height (TreeNode root) {
		return root == null ? -1 : 1 + height(root.left);
	}
	
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int h = height(root);
		// 判断最后一个点在root.left subtree还是root.right subtree
		if (height(root.right) == h-1) {
			//root.right subtree
			return (1 << (h-1+1)) -1 + 1 + countNodes(root.right); // 1 + 2^(h)-1 + rightSubtree
		} else {
			return (1 << (h-2 + 1)) -1 + 1 + countNodes(root.left); // 1 + 2^(h-1)-1 + leftSubtree
		}
	}
	
	public static void main(String[] args) {
		System.out.println(1 << 3); // 2^1
	}
}
