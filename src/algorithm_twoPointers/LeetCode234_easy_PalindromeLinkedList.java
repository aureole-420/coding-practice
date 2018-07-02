package algorithm_twoPointers;

// 做前，没什么想法；array好做因为能直接access各个index的值
// 现有的list没办法得到每个index的值
// 不过list可以用快慢指针找到重点
// 然而如何对比一头一尾，需要一个反向的iterator？

// 做中： https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
// 看了一个答案，茅塞顿开
// 1. 快慢指针找到中点，中点作为第二个list的head 2 reverse后半部分list 3. compare前后两个list
// 翻转list是难点
// O(1) space, O(n) time
public class LeetCode234_easy_PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		// 快慢指针
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// if odd nodes, let right list be smaller
		if (fast != null) {
			slow = slow.next;
		}
		
		slow = reverse(slow);
		
		while (slow != null) {
			if (slow.val != head.val) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		
		return true;
	}
	
	// 
	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		
		return prev;
	}
}
