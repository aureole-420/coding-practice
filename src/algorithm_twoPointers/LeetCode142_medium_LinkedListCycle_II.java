package algorithm_twoPointers;

// 做前；intuitive的做法还是hashset， 第一个重复的就是 begin of cycle
// 用快慢pointer 列了公式： n+k1 m + r = t; n + k2m + r = 1+2t， k1, k2, m, t 都可以测量出来，但是还是不会做。。。求不出n, r


// 看了答案，这题其实利用了“第一次相遇”的情形，可以具体把第一次相遇的位置用相对的表示出来
public class LeetCode142_medium_LinkedListCycle_II {
    public ListNode detectCycle(ListNode head) {
        ListNode intersection = hasCycle(head);
        
        if (intersection == null) {
        		return null;
        }
        
//        ListNode ptr1 = head, ptr2 = intersection;
        while (true) {
        		if (head == intersection) {
        			return head;
        		}
        		head = head.next;
        		intersection = intersection.next;
        }
    }
    
    // return null if no cycle
    // otherwise return the intersection node
    private ListNode hasCycle(ListNode head) {
    		ListNode slow = head, fast = head;
    		
    		while (fast != null && fast.next != null) {
    			fast = fast.next.next;
    			slow = slow.next;
    			if (slow == fast) {
    				return slow;
    			}
    		}
    		
    		return null;
    }
}
