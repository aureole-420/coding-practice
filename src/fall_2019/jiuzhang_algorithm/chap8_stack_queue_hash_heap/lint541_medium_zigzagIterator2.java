package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.Iterator;
import java.util.List;

public class lint541_medium_zigzagIterator2 {

    public class ZigzagIterator2 {

        class ListNode {
            Iterator<Integer> iter;
            ListNode prev, next;
            ListNode(Iterator<Integer> iter) {
                this.iter = iter;
            }
        }


        private ListNode dummyHead, dummyTail; // head and tail of cyclic list
        private ListNode curNode;
        private int numOfIters;
        /*
         * @param vecs: a list of 1d vectors
         */public ZigzagIterator2(List<List<Integer>> vecs) {
            // do intialization if necessary
            dummyHead = new ListNode(null);
            dummyTail = new ListNode(null);
            dummyHead.prev = dummyTail;
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            dummyTail.next = dummyHead;

            numOfIters = 0;
            for (List<Integer> list : vecs) {
                appendToTail(new ListNode(list.iterator()));
                numOfIters++;
            }

            curNode = dummyHead.next;
        }

        /*
         * @return: An integer
         */
        public int next() {
            // write your code here
            int returnValue = curNode.iter.next();
            curNode = curNode.next;
            return returnValue;
        }

        /*
         * @return: True if has next
         */
        public boolean hasNext() {
            // write your code here
            while (numOfIters > 0) {
                if (curNode.iter == null) { // head or tail
                    curNode = curNode.next;
                    continue;
                }

                if (curNode.iter.hasNext()) {
                    return true;
                } else {
                    ListNode nodeToDelete = curNode;
                    curNode = curNode.next;
                    removeNode(nodeToDelete);
                    numOfIters--;
                }
            }

            return false;
        }

        private void appendToTail(ListNode node) {
            ListNode tail = dummyTail.prev;
            tail.next = node;
            dummyTail.prev = node;
            node.prev = tail;
            node.next = dummyTail;
        }

        private void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
