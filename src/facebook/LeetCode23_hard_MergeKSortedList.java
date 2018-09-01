package facebook;

import java.util.*;

// 这就是Two Phase Multiway Merge Sort嘛
public class LeetCode23_hard_MergeKSortedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {return a.val - b.val;});
        ListNode dummyHead = new ListNode(0);
        ListNode currentTail = dummyHead;

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }

        }

        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();

            currentTail.next = cur;
            currentTail = cur;

            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }

        currentTail.next = null; // close the list

        return dummyHead.next;
    }

}
