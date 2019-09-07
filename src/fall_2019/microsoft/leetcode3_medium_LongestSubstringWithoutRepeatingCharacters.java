package fall_2019.microsoft;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode3_medium_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0, end = 0;
        int duplicate = 0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character, Integer> char2Count = new HashMap<>();
        while(end < s.length()) {
            char c = s.charAt(end);
            if (char2Count.containsKey(c) && char2Count.get(c) > 0) { // expand window end
                duplicate++;
            }
            char2Count.put(c, char2Count.getOrDefault(c, 0) + 1);
            end++;

            while (duplicate > 0) {
                char cc = s.charAt(start);
                if (char2Count.get(cc) > 1) {
                    duplicate--;
                }
                char2Count.put(cc, char2Count.get(cc) - 1);
                start++;
            }

            // now [start+1, end] are nonduplicated.

            if (end - start > maxLen) {
                maxLen = end - start;
            }
        }

        return maxLen;
    }
}
