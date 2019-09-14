package fall_2019.microsoft;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode300_medium_longestIncreasingSequence {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0; // the place to fill.
        for (int x : nums) {
            int idx = Arrays.binarySearch(tails, 0, size, x);
            if (idx < 0) {
                idx = -(idx+1);
            }
            tails[idx] = x;
            if (idx == size) size++;
        }

        return size;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,7,11};
        System.out.println(Arrays.binarySearch(arr,3)); // index = 1
        System.out.println(Arrays.binarySearch(arr,10)); // index = -5-1
        System.out.println(Arrays.binarySearch(arr,2)); // index = -1-1
        System.out.println(Arrays.binarySearch(arr,20)); // index = -6-1

        System.out.println(Arrays.binarySearch(arr,0, 3, 5));//-3-1
        System.out.println(Arrays.binarySearch(arr,0, 0, 5));// 0 - 1
    }
}
