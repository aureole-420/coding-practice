package algorithm_ladder_V;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 用bfs就可以了
public class LeetCode102_BTLevelOrderTraversal {
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    		
    		// corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        		return result;
        }
        
        result.add(new LinkedList<Integer>());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        int level = 0;
        
        while(!queue.isEmpty()) {
      		if (num == 0) {
    			result.add(new LinkedList<Integer>());
    			level++;
    			num = queue.size();
      		}
      		
        		TreeNode cur = queue.poll();
        		if (cur.left != null) {
        			queue.offer(cur.left);
        		}
        		if (cur.right != null) {
        			queue.offer(cur.right);
        		}
        		result.get(level).add(cur.val);
        		num--;
        }
        
        return result;
    }
}
