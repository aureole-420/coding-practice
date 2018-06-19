package algorithm_bfs_dfs;

import java.util.*;

// 最简单当然是bfs
public class LeetCode515_medium_FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
    		List<Integer> result = new ArrayList<>();
    		if (root == null) {
    			return result;
    		}
    		
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//        int curLayer = 0;
        int numOfCurLayer = 1;
        result.add(Integer.MIN_VALUE);
        
        
        while (!queue.isEmpty()) {
        		if (numOfCurLayer == 0) {
//        			curLayer++;
        			numOfCurLayer = queue.size();
        			result.add(Integer.MIN_VALUE);
        		}
        		
        		TreeNode cur = queue.poll();
        		numOfCurLayer--;
        		if (result.get(result.size()-1) < cur.val) {
        			result.set(result.size()-1, cur.val);
        		}
        		
        		
        		if (cur.left != null) {
        			queue.offer(cur.left);
        		}
        		if (cur.right != null) {
        			queue.offer(cur.right);
        		}
        }
        return result;
    }	
}
