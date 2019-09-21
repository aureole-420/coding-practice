package fall_2019.microsoft;

public class leetcode114_medium_flatternBinaryTreeToLinkedList {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode[] helper(TreeNode root) {
        if (root == null) return new TreeNode[]{null, null};
        TreeNode[] left = helper(root.left);
        TreeNode[] right = helper(root.right);
        if (left[0] != null) {
            root.left = null;
            root.right = left[0];
            left[1].right = right[0];
        } else {
            root.right = right[0];
        }
        TreeNode rightEnd;
        if (right[1] != null) {
            rightEnd = right[1];
        } else if (left[1] != null) {
            rightEnd = left[1];
        } else {
            rightEnd = root;
        }
        return new TreeNode[]{root, rightEnd};
    }
}
