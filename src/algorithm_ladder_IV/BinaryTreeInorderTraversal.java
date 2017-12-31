package algorithm_ladder_IV;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Lintcode 67, use iteration solution
 * 这题非常重要！！！
 */
public class BinaryTreeInorderTraversal {
	static final  int NOT_DONE = 0; 
	static final int LEFT_DONE = 1;
	static final int LEFT_RIGHT_DONE = 2;
	
	public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Deque<TreeNode> stackNode = new ArrayDeque<TreeNode>();
        Deque<Integer> stackState = new ArrayDeque<Integer>();
        if (root == null) return res;
        
        stackNode.push(root);
        stackState.push(NOT_DONE);
        
        while (!stackNode.isEmpty()) {
        		TreeNode curNode = stackNode.peek();
        		int curState = stackState.peek();

        		
        		if (curState == LEFT_DONE) { // condition for adding node to res.
        			res.add(curNode.val);
        		}
        		
        		// 三种状态转换
        		if (curState == NOT_DONE) {
//        			System.out.println("current node: " + curNode.val + " <>  current state: " + curState);
//        			stackState.set(stackState.size() -1, LEFT_DONE);
        			 stackState.pop();
        			 stackState.push(LEFT_DONE);
//        			System.out.println("<updated> current node: " + curNode.val + " <>  current state: " + stackState.peek());
        			if (curNode.left != null) {
        				stackNode.push(curNode.left);
        				stackState.push(NOT_DONE);
        			}	
        		} else if (curState == LEFT_DONE) {
        			// stackState.set(stackState.size() -1 , LEFT_RIGHT_DONE);
        			stackState.pop(); stackState.push(LEFT_RIGHT_DONE);
        			if (curNode.right != null) {
        				stackNode.push(curNode.right);
        				stackState.push(NOT_DONE);
        			}
        		} else if (curState == LEFT_RIGHT_DONE) {
        			stackNode.pop();
        			stackState.pop();
        		}	
        }
        return res;   
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.left = new TreeNode(4);
		BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
		List<Integer> list = b.inorderTraversal(root);
		for (int i : list) System.out.print(i + " "); // should be 4 1 3 2
	}
}
