package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

public class lint129_medium_rehashing {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode[] rehashing(ListNode[] hashTable) {
        int capacity = hashTable.length * 2;
        System.out.println("=== " + capacity + "=====");

        ListNode[] newHashTable = new ListNode[capacity];
        ListNode[] tails = new ListNode[capacity];

        // write your code here
        for (ListNode head : hashTable) {
            ListNode node = head;
            while (node != null) {

                ListNode curNode = new ListNode(node.val);
                node = node.next;

                int hash = curNode.val % capacity;
                if (hash < 0) hash += capacity;

                System.out.println("node.val = " + curNode.val + " hash =" + hash);


                if (newHashTable[hash] == null) {

                    newHashTable[hash] = curNode;
                    tails[hash] = curNode;
                    curNode.next = null;
                } else {
                    tails[hash].next = curNode;
                    tails[hash] = curNode;
                    curNode.next = null;
                }
            }
        }

        return newHashTable;
    }
}
