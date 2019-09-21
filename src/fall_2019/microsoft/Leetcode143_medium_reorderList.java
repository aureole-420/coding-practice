package fall_2019.microsoft;

public class Leetcode143_medium_reorderList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // 1->2->3->4
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        ListNode fast = head, slow = head;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = slow.next; // 3->4
        slow.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            ListNode first = dummyHead.next;
            cur.next = first;
            dummyHead.next = cur;

            cur = temp;
        }
        // now dummyHead->4->3
        ListNode cur1 = head, cur2 = dummyHead.next;
        while (cur1 != null && cur2 != null) {
            ListNode temp1 =cur1.next, temp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = temp1;

            cur1 = temp1;
            cur2 = temp2;
        }
    }
}
