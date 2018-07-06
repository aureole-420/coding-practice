package algorithm_twoPointers;

// 做前：如果这题是array -- 做不出来
// one pass： iterate list一遍， 遇到小的就往前放   ---- 前插太麻烦了。

// 做中： 看了discussion，用两个queue装比x大和小的数，然后把他们连起来。

// 做后感想： dummy node太有用了，不需要讨论
public class LeetCode86_medium_PartionList {
	
	public ListNode partition(ListNode head, int x)  {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode prev = dummy, small = dummy;
		
		while (head != null) {
			System.out.println(head.val); // input [1,4,3,2,5,2]， 不停地出现1.1。1。1， 代码没考虑small和prev重合的情形。。。。
			// 太麻烦了，还是两个queue简单。
			if (head.val < x) {
				prev.next = head.next;
				
				head.next = small.next;
				small.next = head;
				
			} else {
				prev = head;
			}
			
			head = prev.next;
		}
		
		return dummy.next;
	}
	
	// solution1
//	public ListNode partition(ListNode head, int x) {
//		ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
//		
//		ListNode cur1 = dummy1, cur2 = dummy2;
//		
//		while (head != null) {
//			if (head.val < x) {
//				cur1.next = head;
//				cur1 = cur1.next;
//			} else {
//				cur2.next = head;
//				cur2 = cur2.next;
//			}
//			
//			head = head.next;
//		}
//		
////		cur1.next = null;
//		cur2.next = null;
//		
//		cur1.next = dummy2.next;
//		return dummy1.next;		
//	}
	
	// 不太对？
//    public ListNode partition(ListNode head, int x) {
//        ListNode small = null, prev = null, iter = head;
//        ListNode newHead = null;
//        
//        
//        while (iter != null) {
//        		if (iter.val >= x) {
//        			prev = iter;
//        			iter = iter.next;
//        		} else { // e.g. 1-2-3
//        			ListNode insertAhead = iter;
//        			
//        			if (prev == null) { // first node
//        				prev = iter;
//        				small = iter; 
//        				continue; // 不需要前插
//        			}
//        			
//        			prev.next = iter.next;
//        			iter = iter.next;
//        			
//        			if (small == null) { // first smaller node.
//        				small = insertAhead;
//        				newHead = insertAhead;
//        				insertAhead.next = head;
//        			}
//        			insertAhead.next = small.next;
//        			small.next = insertAhead;       			
//        		}  		
//        }
//        
//        if (newHead == null) {
//        		return head;
//        } else {
//        		return newHead;
//        }
//    }
	
	
}
