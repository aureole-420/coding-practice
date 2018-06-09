package algorithm_graph_I;

import java.util.*;

// bfs 每一层最后一个就是right side view
public class LeetCode199_BTRightSideView {
	
    public List<Integer> rightSideView(TreeNode root) {
    	
    		List<Integer>  res = new ArrayList<>();
    		if (root == null) {
    			return res;
    		}
    		
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int numNodeOfCurLevel = 1;
        
        while (!queue.isEmpty()) {
        		if (numNodeOfCurLevel == 0) {
        			numNodeOfCurLevel = queue.size();
        		}
        		
        		TreeNode cur = queue.poll();
        		if (cur.left != null) {
        			queue.offer(cur.left);
        		}
        		if (cur.right != null) {
        			queue.offer(cur.right);
        		}
        		
        		numNodeOfCurLevel--;
        		if (numNodeOfCurLevel == 0) { // the last one of current level
        			res.add(cur.val);
        		}
        }
        
        return res;
    }
}
