package algorithm_ladder_V;

// leetcode 109
// fast.next != tail && fast.next.next != tail 快慢指针
// complexity
// T(n) = n/2 + T(left) + T(right)
public class LeetCode109_ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
    	
    		if (head == null) {
    			return null;
    		}
    		
        return buildBST(head, null);
    }
    
    private TreeNode buildBST(ListNode head, ListNode tail) {
    		if (head == tail) {
    			return null;
    		}
    		
    		ListNode fast = head, slow = head;
    		while (fast.next != tail && fast.next.next != tail) {
    			fast = fast.next.next;
    			slow = slow.next;
    		}
    		
    		TreeNode root = new TreeNode(slow.val);
    		root.left = buildBST(head, slow);
    		root.right = buildBST(slow.next, tail);
    		
    		return root;
    }
}
