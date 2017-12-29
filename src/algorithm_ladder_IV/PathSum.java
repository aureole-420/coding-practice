package algorithm_ladder_IV;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * lintcode376
 */
public class PathSum {
	
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // base case;
        if (root == null) {
        		return res;
        }
        // is leaf
        if (root.left == null && root.right == null) {
                if (root.val == target) {
                    List<Integer> p = new LinkedList<Integer>();
        	    	p.add(root.val);
        		    res.add(p);  
                }
        		return res;
        }
        
        // not leaf
        List<List<Integer>> left =  binaryTreePathSum(root.left, target - root.val);
        List<List<Integer>> right =  binaryTreePathSum(root.right, target - root.val);
        for (List<Integer> list : left) {
        		LinkedList<Integer> l = new LinkedList<>(list);
        		l.addFirst(root.val);
        		res.add(l);
        }
        for (List<Integer> list : right) {
    		LinkedList<Integer> l = new LinkedList<>(list);
    		l.addFirst(root.val);
    		res.add(l);
        }   
        return res;
    }
}
