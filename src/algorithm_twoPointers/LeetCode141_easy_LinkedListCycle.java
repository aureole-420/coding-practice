package algorithm_twoPointers;

// 做前： 简单的想法是用一个hashset做路径存储，检查有没有重复
// 要求： solve it without extra space

// Myth: 为什么不能判断是否重新回到了head？ --- 因为环的接口不一定在head！
// [3,2,0,-4]
//tail connects to node index 1

// 快慢指针，每次fast比slow多走1个，假设list共有n个node
public class LeetCode141_easy_LinkedListCycle {
//    public boolean hasCycle(ListNode head) {
//       if (head == null) {
//    	       return false;
//       }
//       
//       ListNode ptr = head.next;
//       while (ptr != null) {
//    	   	if (ptr == head) {
//    	   		return true;
//    	   	}
//    	   	ptr = ptr.next;
//       } 
//       
//       return false;  
//    }
	
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slow = head, fast = head.next;
		
		while (fast != null && fast.next != null) {
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
			
		}
		return false;
	}
}
