package algorithm_tree;
import java.util.*;

// 做前： （不对的想法）想把inorder traverse tree然后存到list中，
// 然而：重点： // average O(1) time, O(h) memory
// 如果存了一个数组，那是O(n) space,如果树很大就不行

// 做中：看了答案。。。
// 最初的节点当然是bst的最左边的节点。用stack保存parent 节点。那些节点必然hou iterate。 每次pop出来检查right，有的话right subtree的最左支就是potential next
public class LeetCode173_medium_BSTIterator {
	
	private Stack<TreeNode> stack = new Stack<>();
	
	// constructor 
	// should delete void
    public void BSTIterator(TreeNode root) {
        while (root != null) {
        		stack.push(root);
        		root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    // average O(1) time, O(h) memory
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    // average O(1) time, O(h) memory
    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right != null) {
        		TreeNode temp = cur.right;
        		while (temp != null) {
        			stack.push(temp);
        			temp = temp.left;
        		}
        }
        
        return cur.val;
    }
}
