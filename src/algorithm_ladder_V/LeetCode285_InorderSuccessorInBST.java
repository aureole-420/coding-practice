package algorithm_ladder_V;

// 这题很tricky，重点是当 p < root.val时，successor可能在root.left里面，也可能就是root。
public class LeetCode285_InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
        		return null;
        }
        
        
        if (p.val > root.val) { // then answer must be in the right subtree
        		return inorderSuccessor(root.right, p);
        } else if (p.val < root.val) { // then answer must be EITHER root, or in right subtree,
        		TreeNode temp = inorderSuccessor(root.left, p) ;
        		return temp == null ? root : temp;
        } else {	 // p.val == root.val // 只在左子树中寻找
        		return inorderSuccessor(root.right, p);
        }
        
        // root.val == p.val
//        if (root.right == null) {
//        		return null;
//        } else {
//        		TreeNode ptr = root.right;
//        		while (ptr.left != null) {
//        			ptr = ptr.left;
//        		}
//        		return ptr;
//        }
    }
}
