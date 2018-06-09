package algorithm_ladder_V;

// tricky, 不容易bug free
// 注意是到leaf node为止，需要处理某一subtree为null的情况
public class LeetCode111_easy_MinDepthBT {
    public int minDepth(TreeNode root) {
        if (root == null) {
        		return 0;
        }
        
        if (root.left == null && root.right == null) {
        		return 1;
        }
        
        int lDepth = minDepth(root.left);
        if (root.left == null) lDepth = Integer.MAX_VALUE;
        
        int rDepth = minDepth(root.right);
        if (root.right == null) rDepth = Integer.MAX_VALUE;
        
        return 1 + Math.min(lDepth, rDepth);
    }
}
