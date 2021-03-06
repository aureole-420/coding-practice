package fall_2019.microsoft;

import java.util.HashMap;

public class leetcode76_hard_minWindowSubstring {

    // Input: S = "ADOBECODEBANC", T = "ABC"
    // Output: "BANC
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> char2Count = new HashMap<>();
        for (char c : t.toCharArray()) {
            char2Count.put(c, char2Count.getOrDefault(c, 0) + 1);
        }

        int start=0, end = 0;
        int numCharToInclude = char2Count.size();

        int minLen = Integer.MAX_VALUE;
        int head = 0;
        while (end < s.length()) { // 拓展window size
            char c = s.charAt(end);
            if (char2Count.containsKey(c)) {
                char2Count.put(c, char2Count.get(c) - 1);
                if (char2Count.get(c) == 0) {
                    numCharToInclude--;
                }
            }
            end++;

            while (numCharToInclude == 0) { // 当所有字母全都包含在内时，不再拓展window
                // 转而缩小window size。
                if (end-start < minLen) {
                    minLen = end-start;
                    head = start;
                }

                char c_ = s.charAt(start);
                if (char2Count.containsKey(c_)) {
                    char2Count.put(c_, char2Count.get(c_) + 1);

                    if (char2Count.get(c_) > 0) { // 当条件不满足，i.e.，并非所有字母包含在内时，
                        // 停止缩小window size，再次增大window
                        numCharToInclude++;
                    }
                }

                start++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(head, head + minLen);
    }
}
