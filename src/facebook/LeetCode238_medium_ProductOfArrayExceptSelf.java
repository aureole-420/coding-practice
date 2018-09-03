package facebook;


import java.util.*;


// Use tmp to store temporary multiply result by two directions. Then fill it into result. Bingo!
public class LeetCode238_medium_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        //
        for (int i = 0, left = 1; i < nums.length; i++) {
            res[i] *= left;
            left *= nums[i];
        }

        for (int i = nums.length-1, right = 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

}
