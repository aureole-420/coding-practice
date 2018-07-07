package algorithm_twoPointers;

import java.util.*;

// 做前：之前刚做了159， 340， 3。 那些题用hashmap做；但这里需要取最大值，所以想到用treeset
// treeset<K,V>, K is the number, V is # of number repeats
// debug: 46 行，写成了put(key, 0) 应该是 key：1
// 因为treemap底层是红黑树，所以O(nlogn)

// 做后： 单调队列 O（n）
// 有点难；单调队列只存储potentially maximum的值
// -- 当一个大值进来时，所有的小值全部都被踢掉 （这些小值不可能成为最大值了了）
// -- 小的值插入队尾，因为你不知道后面它会不会成为最大

// remove element out of window of size k (pollFirst) 队首移除 多余元素
// remove element that can never be MAX from tail (pollLast)
// deque 存的是index！
// https://www.youtube.com/watch?v=J6o_Wz-UGvc
public class LeetCode239_hard_SlidingWindowMaximum {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) {
			return new int[0];
		}
		
		int n = nums.length;
		int[] res = new int[n-k+1];  
		Deque<Integer> q = new ArrayDeque<>(); // 存的是index！！！！
		
		int resIdx = 0;
		for (int i = 0; i < n; i++) {
			// remove numbers out of k -- from front
			while (!q.isEmpty() && q.peek() < i-k+1) {
				q.pollFirst();
			}
			
			// remove smaller numbers in k ranges as they are useless! --- from tail
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			
			q.offer(i);
			if (i >= k-1) {
				res[resIdx++] = nums[q.peek()];
			}
		}
		
		return res;
	}
	
	// solution2
//    public int[] maxSlidingWindow(int[] nums, int k) {
//    	 	// corner case;
//    		if (nums == null || nums.length == 0 || k > nums.length) {
//    			return new int[0];
//    		}
//    		
//    		int[] result = new int[nums.length-k+1];
//    		TreeMap<Integer, Integer> map = new TreeMap<>((Integer a, Integer b)-> b-a); // map
//    		
//    		for (int i = 0; i < k; i++) {
//    			addInt(map, nums[i]);
//    		}
//    		
//    		int i = 0, j = k-1;
//    		while (i < result.length) {
//    			
//    			System.out.println(map.size());
//    			result[i] = map.firstKey();
//    				
//    			i++; j++;
//    			
//    			System.out.println("going to remove key:" + nums[i-1]);
//    			removeInt(map, nums[i-1]);
//    			if (j < nums.length) {
//    				addInt(map, nums[j]);
//    			}
//    			
//    		}
//    		
//    		return result;
//    }
//    
//    private void addInt(TreeMap<Integer, Integer> map, int a) {
//    		System.out.println("Add key::"+a);
//    		if (map.containsKey(a)) {
//    			map.put(a, map.get(a) + 1);
//    		} else {
//    			map.put(a, 1); // 
//    		}
//    }
//    
//    private void removeInt(TreeMap<Integer, Integer> map, int a) {
//    		if (map.get(a) == 1) {
//    			map.remove(a);
//    		} else {
//    			map.put(a, map.get(a) - 1);
//    		}
//    }
//    
//    public static void main(String[] args) {
//    		LeetCode239_hard_SlidingWindowMaximum sw = new LeetCode239_hard_SlidingWindowMaximum();
//    		int[] arr = new int[] {1,3,1,2,0,5};
//    		sw.maxSlidingWindow(arr, 3);
//    }
}
