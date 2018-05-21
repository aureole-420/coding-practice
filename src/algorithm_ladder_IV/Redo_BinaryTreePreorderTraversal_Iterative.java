package algorithm_ladder_IV;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// O(n), O(n) extra space.
public class Redo_BinaryTreePreorderTraversal_Iterative {
	
	static final int NOT_DONE = 1;
	static final int LEFT_DONE = 2;
	static final int LEFT_RIGHT_DONE = 3;
	
    public List<Integer> preorderTraversal(TreeNode root) {
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
        			result.add(curNode.val);
        			nodeStack.pop();
        			statusStack.pop();
        			
        			// then push right, push left --- we want deal with left subtree first
        			if (curNode.right != null) {
        				nodeStack.push(curNode.right);
        				statusStack.push(NOT_DONE);
        			} 
        			if (curNode.left != null) {
        				nodeStack.push(curNode.left);
        				statusStack.push(NOT_DONE);
        			} 

        		}
        }
        
        return result;
    }
    
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		Redo_BinaryTreePreorderTraversal_Iterative bt = new Redo_BinaryTreePreorderTraversal_Iterative();
		List<Integer> res = bt.preorderTraversal(root);
		
		for (int i : res) {
			System.out.println(i); // should be 1 2 3
		}
	}
}
