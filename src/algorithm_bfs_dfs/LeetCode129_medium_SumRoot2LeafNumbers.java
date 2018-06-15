package algorithm_bfs_dfs;
import java.util.*;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
// 做后感受：跟pathSum差不多，还是要想清楚backtracking怎么做。
public class LeetCode129_medium_SumRoot2LeafNumbers {
    public int sumNumbers(TreeNode root) {
        List<String> strings = new LinkedList<>();
        
        if (root == null) {
        		return 0;
        }
        
        dfs(root, new StringBuilder(), strings);
        
        int sum = 0;
        for (String s : strings) {
        		sum += Integer.parseInt(s);
        }
        return sum;
    }
    
    private void dfs(TreeNode root, StringBuilder sb, List<String> strings) {
    		if (root == null) {
    			return;
    		}
    		
    		sb.append(Integer.toString(root.val));
    		
    		if (root.left == null && root.right == null) { // a leaf	found	
    			strings.add(sb.toString());
    		} 
    		
    		// dfs subtrees
    		if (root.left != null) {
    			dfs(root.left, sb, strings);
    		}
    		if (root.right != null) {
    			dfs(root.right, sb, strings);
    		}
    		
    		sb.deleteCharAt(sb.length()-1);
    	
    }
}
