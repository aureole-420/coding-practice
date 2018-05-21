package algorithm_ladder_IV;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


// first dfs 
// iterative method, 我是用了两个状态，leftDone, rightDone, 其实就一种状态
// 如果这个node从没被处理过，那么就 right - self - left 顺序加一遍
// 这样node就变成Done的状态，下次peek就可以直接pop output

// improve 改进，这样子space efficiency低，
// 改进，三个状态， NOT done, leftDone, leftRightDone
// 在 leftDone 状态就output result
public class Redo_BinaryTreeInorderTraversal {
	class Status {
		boolean leftDone;
		boolean rightDone;
		Status (boolean l, boolean r) {
			leftDone = l;
			rightDone = r;
		}
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		
		Deque<TreeNode> nodeStack = new ArrayDeque<>();
		Deque<Status> statusStack = new ArrayDeque<>();
		
		nodeStack.push(root);
		statusStack.push(new Status(false, false));
		
		while (!nodeStack.isEmpty()) {
			Status status = statusStack.peek();
			
			if (status.leftDone && status.rightDone) {
				TreeNode node = nodeStack.pop();
				result.add(node.val);
				statusStack.pop();
			}  else if (!status.leftDone && !status.rightDone) { // subtree hasn't been treated yet
				TreeNode curNode = nodeStack.pop();
				Status curStatus = statusStack.pop();
				// push right -> self ->  left;
				if (curNode.right != null) {
					nodeStack.push(curNode.right);
					statusStack.push(new Status(false, false));
				}
				
				nodeStack.push(curNode);
				statusStack.push(new Status(true, true));
				
				if (curNode.left != null) {
					nodeStack.push(curNode.left);
					statusStack.push(new Status(false, false));
				}
			} 
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		Redo_BinaryTreeInorderTraversal bt = new Redo_BinaryTreeInorderTraversal();
		List<Integer> res = bt.inorderTraversal(root);
		
		for (int i : res) {
			System.out.println(i);
		}
	}
}
	
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        
//        dfs(root, result);
//        return result;
//    }
//    
//    private void dfs(TreeNode root, List<Integer> result) {
//    		// base case
//    		if (root == null) {
//    			return;
//    		}
//    		
//    		dfs(root.left, result);
//    		result.add(root.val);
////    		dfs(root.right, result);
////    }
//}
