package facebook_more;

import java.util.*;


// 典型的devide conquer
public class LeetCode426_medium_ConvertBST2SortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }

        Node leftList = treeToDoublyList(root.left);
        Node rightList = treeToDoublyList(root.right);

        Node lhead = null, ltail = null, rhead = null, rtail = null;
        if (leftList != null) {
            lhead = leftList;
            ltail = leftList.left;
        }
        if (rightList != null) {
            rhead = rightList;
            rtail = rightList.left;
        }

        Node curHead = null, curTail = null;
        if (lhead != null) {
            curHead = lhead;
            ltail.right = root;
            root.left = ltail;
        } else {
            curHead = root;
        }

        if (rhead != null) {
            curTail = rtail;
            root.right = rhead;
            rhead.left = root;

        } else {
            curTail = root;
        }

        curHead.left = curTail;
        curTail.right = curHead;

        return curHead;
    }
}
