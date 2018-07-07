package algorithm_HashTable;

import java.util.*;

// 做前： 这题在lintcode里面做过？ 用hashmap<ListNode, ListNode> 先copy一遍
public class LeetCode138_medium_CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        
    		// phase i; copy nodes
    		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    		
    		for (RandomListNode cur = head; cur != null; cur = cur.next) {
    			map.put(cur, new RandomListNode(cur.label));
    		}
    		
    		// phase ii: copy pointers
    		for (RandomListNode cur = head; cur != null; cur = cur.next) {
    			map.get(cur).next = map.get(cur.next);
    			map.get(cur).random = map.get(cur.random);
    		}
    		
    		return map.get(head);
    }
}
