package fall_2019.microsoft;

public class leetcode206_easy_reverseLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
//    public ListNode reverseList(ListNode head) {
//        if (head == null) return head;
//
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode prev = head, cur = head.next;
//        while (cur != null) {
//            ListNode temp = cur.next;
//            prev.next = temp;
//            cur.next = dummyHead.next;
//            dummyHead.next = cur;
//
//            cur = temp;
//        }
//
//        return dummyHead.next;
//    }

//    // iterative solution
//    public ListNode reverseList(ListNode head) {
//        ListNode dummyHead = new ListNode(-1);
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode temp = cur.next;
//            cur.next = dummyHead.next;
//            dummyHead.next = cur;
//            cur = temp;
//        }
//
//        return dummyHead.next;
//    }

    // recursive solution
    public ListNode reverseList(ListNode head) { // 1->2->3->4
        if (head == null || head.next == null) return head;
        ListNode tailOfRest = head.next; // 2
        ListNode reversedRest = reverseList(head.next);
        tailOfRest.next = head;
        head.next = null; // 这个忘了写的话，递归就没有尽头了！！！！
        return reversedRest;
    }

    public static void main(String[] args) {

    }
}
