package facebook_more;

public class LeetCode92_medium_ReverseLinkedList_II {



    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next= head;
        ListNode reverseHead = dummyHead;
        ListNode cur = head;
        ListNode reverseTail = null;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                reverseHead = reverseHead.next;
                cur = cur.next;
                continue;

            }
            if (i == m) {
                reverseTail = cur;
            }
            // otherwise
            ListNode temp = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;

            cur = temp;
        }
        reverseTail.next= cur;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        LeetCode92_medium_ReverseLinkedList_II rll = new LeetCode92_medium_ReverseLinkedList_II();
        rll.reverseBetween(root, 2, 4);
    }
}
