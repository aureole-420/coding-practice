package fall_2019.jiuzhang_algorithm.chap3_two_pointers;

import java.util.Arrays;

public class lint382_medium_triangleCount {

    // valid triangle: a + b > c, c is the longest edge of the triangle
    public int triangleCount(int[] S) {
        Arrays.sort(S);

        int ans = 0;
        for (int i = S.length-1; i > 0; i--) {
            int left = 0;
            int right = i-1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    // a = left, left+1, ..., right-1
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}
