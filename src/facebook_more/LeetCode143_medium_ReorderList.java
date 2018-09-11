package facebook_more;
import java.util.*;


public class LeetCode143_medium_ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curTail = dummy;
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.offer(head);
            head = head.next;
        }

        boolean popHead = true;
        while (!deque.isEmpty()) {
            ListNode cur;
            if (popHead) {
                cur = deque.pollFirst();
            } else {
                cur = deque.pollLast();
            }
            popHead = !popHead;
            curTail.next = cur;
            cur.next = null;//这步很重要。
            curTail = curTail.next;
        }

        dummy.next = null;
        return;
    }
}
