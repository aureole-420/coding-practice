package algorithm_ladder_IV;

import java.util.ArrayList;
import java.util.List;

// O(n)
public class PathSum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
    		
    		// base case 
    		if (root == null) {
    			return result;
    		}
    		// is leaf
    		if (root.left == null && root.right == null) {
    			if (sum == root.val) {
    				List<Integer> list = new ArrayList<Integer>();
    				list.add(root.val);
    				result.add(list);
    			}
    		}
    		
    		// otherwise:
    		List<List<Integer>> leftRes = pathSum(root.left, sum-root.val);
    		List<List<Integer>> rightRes = pathSum(root.right, sum-root.val);
    		
    		for (List<Integer> temp : leftRes) {
    			List<Integer> list = new ArrayList<>();
    			list.add(root.val);
    			list.addAll(temp);
    			result.add(list);
    		}
    		
    		for (List<Integer> temp : rightRes) {
    			List<Integer> list = new ArrayList<>();
    			list.add(root.val);
    			list.addAll(temp);
    			result.add(list);
    		}
    		
    		return result;
    }
    
    public void printList(List<Integer> list) {
    		for (Integer i : list) {
    			System.out.print(i + " ");
    		}
    		System.out.print("\n");
    }
    
    public static void main(String[] args) {
    		TreeNode root = new TreeNode(10);
    		root.left = new TreeNode(12);
    		root.right = new TreeNode(5);
    		root.right.right = new TreeNode(7);
    		root.right.left = new TreeNode(2);
    		
    		PathSum_II ps = new PathSum_II();
    		List<List<Integer>> result = ps.pathSum(root, 22);
    		for (List<Integer> list : result) {
    			ps.printList(list);
    		}
    }
}
