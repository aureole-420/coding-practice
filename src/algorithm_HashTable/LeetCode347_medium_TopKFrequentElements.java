package algorithm_HashTable;

import java.util.*;

// 做前: 方法挺多的，用排序+iteration， hashMap + 排序， treeset 但后两者的worst case也是O(nlogn)啊

// 做中1: 发现想差了， hashmap count O(n),然后maintain一个k size的priority queue，O(nlogk)
// 做中2: bucket sort 太屌了，已知sort的范围 O(n)
public class LeetCode347_medium_TopKFrequentElements {
	
	 // solution 2. bucket sort
	 public List<Integer> topKFrequent(int[] nums, int k) {
		 
		 // count frequency: frequency can only be in [0, n], therefore we can use bucket sort
		 HashMap<Integer, Integer> count = new HashMap<>();
		 for (int num : nums) {
			 count.put(num, count.getOrDefault(num, 0) + 1);
		 }
		 
		 // bucket sort
		 List<Integer>[] buckets = (List<Integer>[]) new List[nums.length + 1];
		 for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			 int num = entry.getKey();
			 int frequency = entry.getValue();
			 if (buckets[frequency] == null) {
				 buckets[frequency] = new LinkedList<>();
			 }
			 buckets[frequency].add(num);
		 }
		 
		 // join results;
		 
		 List<Integer> res = new LinkedList<>();
		 for (int i = buckets.length-1; i >= 0 && res.size() < k; i--) {
			 if (buckets[i] != null) {
				 res.addAll(buckets[i]);
			 }
		 }
		 
		 return res;
	 }
	
//	// sol 1 O(nlogk)
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> count = new HashMap<>();
//        for (int num : nums) {
//        		count.put(num, count.getOrDefault(num, 0) + 1);
//        }
//        
//        // min pq， always delete min in the process
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
//        
//        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
//        		pq.offer(entry);
//        		if (pq.size() > k) {
//        			pq.poll();
//        		}
//        }
//        
//        List<Integer> res = new LinkedList<>();
//        while (!pq.isEmpty()) {
//        		res.add(0, pq.poll().getKey());
//        }
//        
//        return res;
//    }
}
