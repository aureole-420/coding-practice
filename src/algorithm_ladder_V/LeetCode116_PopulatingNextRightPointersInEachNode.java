package algorithm_ladder_V;

//import static org.junit.Assert.assertNotNull;

// 这题蛮奇怪，要求constant extra space
// 一种做法是用bfs，把同一层的都相连 ， left 2 right， 所以必然是顺序正确 --- 问题是会maintain一个queue
// 另一种做法是divide and conquer，每次连结： 1: self.left => self.right --- 关键题目说用stack expense不算
public class LeetCode116_PopulatingNextRightPointersInEachNode {
	
 	public class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }
 	
    public void connect(TreeLinkNode root) {
        if (root == null) {
        		return;
        }
        
        if (root.left !=  null && root.right != null) {
        		root.left.next = root.right;
        }
        
        if (root.next != null) {
        		if (root.right != null && root.left != null) {
        			root.right.next = root.next.left;
        		}
        }
        
        connect(root.left);
        connect(root.right);
    }
}
