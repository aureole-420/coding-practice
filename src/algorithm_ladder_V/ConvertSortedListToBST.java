package algorithm_ladder_V;

public class ConvertSortedListToBST {
	 public TreeNode sortedListToBST(ListNode head) {
		 if (head == null) return null;
		 
	     return toBST(head, null); 
	 }
	 
	 private TreeNode toBST(ListNode head, ListNode tail) {
		 if (head == tail) return null;
		 
		 ListNode slow = head;
		 ListNode fast = head;
		 
		 // 这个双指针(在list中)找中点 太经典了！！！
		 //注意是 fast != tail 不是 != null.
		 while (fast != tail && fast.next != tail) {
			 slow = slow.next;
			 fast = fast.next.next;
		 }
		 TreeNode root = new TreeNode(slow.val);
		 root.left = toBST(head, slow);
		 root.right = toBST(slow.next, tail);
		 return root;
	 }
}
