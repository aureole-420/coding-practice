package facebook;
import java.util.*;


// 这题超好， 要求O(n)
// 用hashset存数，每次只从最小的那个开始找齐，所有元素只会被遍历一次
public class LeetCode128_hard_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int lcs = 0; // incase the nums is null / empty

        for (int num : nums) {
            int curLCS = 1;
            if (!set.contains(num-1)) { // num is the first of a sequence
                while (set.contains(num+1)) {
                    curLCS++;
                    num++;
                }
            }

            lcs = Math.max(lcs, curLCS);
        }

        return lcs;
    }

}
