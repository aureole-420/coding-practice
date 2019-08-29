package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.PriorityQueue;

public class TopKLargestNumbers {

    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // minHeap

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = heap.poll();
        }

        return result;
    }
}
