package algorithm_twoPointers;

// 做前，先遍历一遍？得到长度后再
// dummy is a nice practice, The logic is more clear with the dummy node.
// 用了dummy head，找第n个node -- 从dummy开始next n次
// 找第n个节点的prev -- 从dummy开始，next n-1次
public class LeetCode61_medium_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
    		if (head == null) {
    			return head;
    		}
    			
    		ListNode dummy = new ListNode(0);
    		dummy.next = head;
    		
    		int len = 0;
    		ListNode fast = dummy;
    		while (fast.next != null) {
    			fast = fast.next;
    			len++;
    		}
    		
    		ListNode slow = dummy;
    		for (int idx = 0; idx < len - k%len; idx++) {
    			slow = slow.next;
    		}
    		
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
        
    }
    
}
