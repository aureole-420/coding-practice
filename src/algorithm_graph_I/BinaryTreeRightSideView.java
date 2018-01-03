package algorithm_graph_I;

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) 
        		return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int layerSize = 1;
        
        while (!queue.isEmpty()) {
        		TreeNode cur = queue.poll();
        		layerSize--;
        		if (cur.left != null) {
        			queue.offer(cur.left);
        		}
        			
        		if (cur.right != null) {
        			queue.offer(cur.right);
        		}

        		if (layerSize == 0) {
        			layerSize = queue.size();
        			res.add(cur.val);
        		}
        }
        return res;
    }
    
    public static void main(String[] args) {
    		TreeNode root = new TreeNode(1);
    		root.left = new TreeNode(2); root.left.right = new TreeNode(5);
    		root.right = new TreeNode(3); root.right.right = new TreeNode(4);
    		BinaryTreeRightSideView b = new BinaryTreeRightSideView();
    		List<Integer> r = b.rightSideView(root);
    		for (int i : r)
    			System.out.print(i + " "); // should be 1 3 4
    }
}
