package algorithm_ladder_IV;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		
		if (root == null) return res;
		
		// if leaf
		if (root.left == null && root.right == null) {
			res.add("" + root.val);
			return res;
		}
		
		// if not leaf
		List<String> left = binaryTreePaths(root.left);
		List<String> right = binaryTreePaths(root.right);
		for (String s : left) 
			res.add(root.val + "->" + s);
		for (String s : right) 
			res.add(root.val + "->" + s);
		
		return res;
    }
}
