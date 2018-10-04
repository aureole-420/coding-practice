package expedia_OA;

public class LeetCode713_medium_SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) return 0;

        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (left <= right && prod >= k) {
                prod /= nums[left++]; // 到了i = j+1时 prod = 1 必定满足 prod < k
            }
            // 如果是 left > right => ans += 0
            // 如果是 prod < k, 则left, left+1, ..., right 都可以作为区间的left bound
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode713_medium_SubarrayProductLessThanK nsp = new LeetCode713_medium_SubarrayProductLessThanK();
        int[] arr = new int[]{3,4,5}; int k = 2;
        nsp.numSubarrayProductLessThanK(arr, k);

    }
}
