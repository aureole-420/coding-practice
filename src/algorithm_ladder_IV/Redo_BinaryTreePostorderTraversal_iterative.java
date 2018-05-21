package algorithm_ladder_IV;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Redo_BinaryTreePostorderTraversal_iterative {
	static final int NOT_DONE = 1;
	static final int LEFT_DONE = 2;
	static final int LEFT_RIGHT_DONE = 3;
	
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
        		return result;
        }
        
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> statusStack = new ArrayDeque<>();
        
        nodeStack.push(root);
        statusStack.push(NOT_DONE);
        
        while (!nodeStack.isEmpty()) {
    			TreeNode curNode = nodeStack.peek();
    			int status = statusStack.peek();
    			
    			if (status == NOT_DONE) {
    				statusStack.pop();
    				statusStack.push(LEFT_DONE);
    				
    				if (curNode.left != null) {
    					nodeStack.push(curNode.left);
    					statusStack.push(NOT_DONE);
    				}
    			} else if (status == LEFT_DONE) { //左子树遍历完了，可以遍历右子树了
    				statusStack.pop();
    				statusStack.push(LEFT_RIGHT_DONE);
    				if (curNode.right != null) {
    					nodeStack.push(curNode.right);
    					statusStack.push(NOT_DONE);
    				}
    			} else {
    				result.add(curNode.val);
    				statusStack.pop();
    				nodeStack.pop();
    			}
        }
		return result;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		Redo_BinaryTreePostorderTraversal_iterative bt = new Redo_BinaryTreePostorderTraversal_iterative();
		List<Integer> res = bt.postorderTraversal(root);
		
		for (int i : res) {
			System.out.println(i); // should be 1 2 3
		}
	}
}
