package algorithm_bfs_dfs;
import java.util.*;

// https://leetcode.com/problems/binary-tree-paths/description/
// 简单的dfs可以做

// 更简单的方法：用分治递归，每一层返回List<String>
// 上层在所有的String里面再加上一个root.val!
public class LeetCode257_easy_BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        
        List<String> list = new LinkedList<>();
        
        dfs(root, list, result);
        
        return result;
    }
    
    private void dfs(TreeNode root, List<String> list, List<String> result) {
    		if (root == null) {
    			return;
    		}
    		
 		if (list.size() != 0) {
				list.add("->"+root.val);
		} else {
				list.add(Integer.toString(root.val));
		}
    		
    		if (root.left == null && root.right == null) {
    			result.add(list2String(list));
    		}
    		
    		if (root.left != null) {
    			dfs(root.left, list, result);
    		}
    		if (root.right != null) {
    			dfs(root.right, list, result);
    		}
    		
    		list.remove(list.size()-1);
    }
    
    private String list2String(List<String> list) {
    		StringBuilder sb = new StringBuilder();
    		for (String s : list) {
    			sb.append(s);
    		}
    		
    		return sb.toString();
    }
}
