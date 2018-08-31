package algorithm_queue;
import java.util.*;

// geek for geeks 上的讲解非常好
// 核心数据结构是doublylinkedlist和hashtable

// 每次最新的放在最前面，需要evict时从最后剔除

// DLinked List只需要下面几个基本操作就可以完成 LRUCache
// 1. addNode(node)  --- 永远把node加在最前面
// 2. remove(node) --- 把该node剔除 -- 所以把某个node提前， moveToHead 就是 remove(node) -> add(Node)
// 3. popTail() -- 永远是剔除tail.prev

// 使用front, tail两个dummy node


// 教训： 一定要画图，写addNode
public class LeetCode146_hard_LRUCache {

    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev, next;
    }

    // key, Dlinkednode
    HashMap<Integer, DLinkedNode> cache;
    DLinkedNode FRONT, TAIL;
    int capacity; // memory 大小

    public void LRUCache(int capacity) { // remove void when submitting code on LeetCode
        this.capacity = capacity;
        cache = new HashMap<>();
        FRONT = new DLinkedNode();
        TAIL = new DLinkedNode();
        FRONT.next = TAIL; FRONT.prev = null;
        TAIL.prev = FRONT; TAIL.next = null;
    }

    // promote most recently access file to head.
    public int get(int key) {
        // trying to get from cache
        DLinkedNode node = cache.get(key);

        if (node == null) {
            return -1; // not found
        }

        moveToHead(node);
        return node.val;
    }

    //
    public void put(int key, int value) {
        System.out.println("Trying to put: " + key + " " + value);
        DLinkedNode node = cache.get(key);
        if (node != null) { // already in cache, just update it
            node.val = value;
            moveToHead(node);
        } else { // not in cache
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.val = value;


            if (cache.size() == capacity) { // need to evict first before inserting
                DLinkedNode temp = popTail();
                cache.remove(temp.key);
            }

            cache.put(key, newNode);
            addNode(newNode);
        }
    }


    // add a node to the front
    private void addNode(DLinkedNode node) {
        DLinkedNode temp = FRONT.next;
        FRONT.next = node;
        node.next = temp;
        node.prev = FRONT;
        temp.prev = node; // 这句话没写，debug半天才出来。
    }

    private DLinkedNode removeNode(DLinkedNode node) {
        DLinkedNode tempPrev = node.prev;
        DLinkedNode tempNext = node.next;

        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;

        return node;
    }

    private DLinkedNode popTail() {
        return removeNode(TAIL.prev);
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }


    public static void main(String[] args) {
        LeetCode146_hard_LRUCache lru = new LeetCode146_hard_LRUCache();

        lru.LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }


}
