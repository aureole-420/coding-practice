package algorithm_twoPointers;

// two pass: count the number of nodes in the list, and then ..
// two pointers.
// the nth node: n = 1, .... Len(List)
// 指针1，一直往后指
// 指针2，当指针一指到n时才开始走
public class LeetCode19_medium_RemoveNthNodeFromEndOfList {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	
    		// prev指针指向要删除的节点
        	ListNode prev = null, fast = head;
        	
        	int count = 0;
        	while (fast.next != null) {
        		fast = fast.next;
        		count++;
        		if (count == n) {
        			prev = head;
        		}
        		if (count > n) {
        			prev = prev.next;
        		}		
        	}
        	
        	if (prev == null) { // remove the head
        		ListNode newHead = head.next;
        		head.next = null;
        		return newHead;
        	} else {
        		ListNode temp = prev.next.next;
        		prev.next.next = null;
        		prev.next = temp;
        		
        		return head; // 
        	}
    }
}
