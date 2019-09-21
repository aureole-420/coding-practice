package fall_2019.microsoft;

public class leetcode510_medium_inorderSuccesorInBST_III {

    class Node {
        int val;
        Node left, right, parent;
    }
    public Node inorderSuccessor(Node x) {
        // in x.right
        if (x.right != null) {
            Node cur = x.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }

        // x parent
        Node father = x.parent;
        Node cur = x;
        while (father != null) {
            if (father.val < cur.val) {
                cur = father;
                father = father.parent;
            } else {
                break;
            }
        }
        return father;
    }
}
