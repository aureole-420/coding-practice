package algorithm_tree;
import java.util.*;
// 做前： 一脸懵逼

// 这题跟Unique BST I有点像
// i当root时，左子树是（1， 。。。 i-1） 构成, 右子树是（i+1, ...., n）构成
// 不加优化的，直接用上面的算法 分治
// 加优化则用一个hashMap
// https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31508/Divide-and-conquer.-F(i)-G(i-1)-*-G(n-i)
public class LeetCode95_medium_UniqueBST_II {
	
    public List<TreeNode> generateTrees(int n) {
    		// 注意n=0的corner case和generateSubtrees不一样。
    		if (n == 0) {
    			return new LinkedList<TreeNode>();
    		}
        return generateSubtrees(1, n);
    }
    
    private List<TreeNode> generateSubtrees(int s, int e) {
    		List<TreeNode> res = new LinkedList<>();
    		if (s > e) {
    			res.add(null);
    			return res;
    		}
    		
    		for (int i = s; i <= e; i++) {
    			List<TreeNode> leftSubtrees = generateSubtrees(s, i-1); // 如果 i=s,这里会返回null
    			List<TreeNode> rightSubtrees = generateSubtrees(i+1, e); 
    			for (TreeNode left : leftSubtrees) {
    				for (TreeNode right : rightSubtrees) {
    					TreeNode root = new TreeNode(i);
    					root.left = left;
    					root.right = right;
    					res.add(root);
    				}
    			}
    		}
    		
    		return res;
    }
}
