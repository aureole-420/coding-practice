package facebook_more;

public class LeetCode543_easy_DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    // number of nodes from current to root.
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(ans, L+ R + 1);
        return Math.max(L, R) + 1;
    }
}
