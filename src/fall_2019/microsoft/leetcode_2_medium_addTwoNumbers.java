package fall_2019.microsoft;

public class leetcode_2_medium_addTwoNumbers {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = l1, p2 = l2;
        ListNode tail = dummyHead;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int v1 = p1 != null ? p1.val : 0;
            int v2 = p2 != null ? p2.val : 0;
            int cur = carry + v1 + v2;
            carry = cur / 10;
            tail.next =  new ListNode(cur % 10);
            tail = tail.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            tail.next = newNode;
        }

        return dummyHead.next;
    }
}
