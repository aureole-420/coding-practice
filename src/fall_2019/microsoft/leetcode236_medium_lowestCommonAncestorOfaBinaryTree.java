package fall_2019.microsoft;

public class leetcode236_medium_lowestCommonAncestorOfaBinaryTree {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return null;
        if (cur == p || cur ==q) return cur;

        TreeNode left = helper(cur.left, p, q);
        TreeNode right = helper(cur.right, p, q);
        if (left != null && right != null) {
            return cur;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}
