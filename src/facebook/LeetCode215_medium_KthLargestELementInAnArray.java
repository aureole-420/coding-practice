package facebook;
import java.util.*;

// 简单的 pq ---- 【java pq】没有duplicate restriction！！！想要duplicate需要自己弄一个set  O(nlogk)
// 复杂的，shuffle + quicksort --- O(n)
// quick selection

// 详见： https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained/171920
// Rank selection uses the partition method from quicksort. Randomized quicksort runs in O(nlogn) expected time with high probability, O(n^2) worst case. The proof for the expected run time can be found in cormen, but roughly speaking, when you randomly choose a pivot, it is nearly in the center of the array, so one can assume it cuts the array into a constant fraction.
//
//Thus if we take a simplistic view of the math, then Quicksort has a running time of
//
//T(n) = 2 * T(n / 2) + O(n).
//T(n) = O(nlogn)
//
//BUT, selection makes the following observation. After the single call to partition, the pivot is in its final position in the sorted array. Thus we know the rank of the pivot immediately, and can then determine if the element we are searching for is to the left, right, or is the pivot itself. This requires only one recursive call.
//
//So quickselect has the following running time.
//
//T(n) = T(n/2) + O(n)
//T(n) = O(n).
public class LeetCode215_medium_KthLargestELementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
