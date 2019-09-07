package fall_2019.microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class leetcode438_hard_FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        HashMap<Character, Integer> char2Count = new HashMap<>();
        for (char c : p.toCharArray()) {
            char2Count.put(c, char2Count.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int numDistinctCharToInclude = char2Count.size();

        while (end < s.length()) { // 不断拓展window size
            char c = s.charAt(end);
            if (char2Count.containsKey(c)) {
                char2Count.put(c, char2Count.get(c) - 1);
                if (char2Count.get(c) == 0) {
                    numDistinctCharToInclude--;
                }
            }
            end++;

            while (numDistinctCharToInclude == 0) {
                if (end - start == p.length()) {
                    result.add(start);
                }

                char cc = s.charAt(start);
                if (char2Count.containsKey(cc)) {
                    char2Count.put(cc, char2Count.get(cc) + 1);
                    if (char2Count.get(cc) > 0) {
                        numDistinctCharToInclude++;
                    }
                }

                start++;
            }
        }

        return result;
    }
}
