package fall_2019.microsoft;

import java.util.HashMap;

public class leetcode159_LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> char2Count = new HashMap<>();
        int start = 0, end = 0;
        int distinctCharCount = 0;

        int maxLen = -1;
        while (end < s.length()) {
            char c = s.charAt(end); //expand window end
            char2Count.put(c, char2Count.getOrDefault(c, 0) + 1);
            if (char2Count.get(c) == 1) {
                distinctCharCount++;
            }
            end++;

            while (distinctCharCount > 2) {
                char cc = s.charAt(start);
                char2Count.put(cc, char2Count.get(cc) - 1);
                if (char2Count.get(cc) == 0) {
                    distinctCharCount--;
                }
                start++;
            }

            if (end - start > maxLen) {
                maxLen = end - start;
            }
        }

        return maxLen;
    }
}
