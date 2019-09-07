package fall_2019.microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leetcode30_hard_SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (s == null || words == null || words.length == 0 || words.length * words[0].length() > s.length()) {
            return result;
        }

        int wl = words[0].length();
        int N = words.length; // in total N words
        HashMap<String, Integer> word2Count = new HashMap<>(); // read-only
        for (String word : words) {
            word2Count.put(word, word2Count.getOrDefault(word, 0) + 1);
        }

        HashMap<String, Integer> localWord2Count = new HashMap<>();
        for (int i = 0; i < wl; i++) {
            int start = i, end = i;
            int wordToInclude = word2Count.size();
            while (end + wl <= s.length()) { // 拓展window end
                String curWord = s.substring(end, end+wl);
                if (word2Count.containsKey(curWord)) {
                    localWord2Count.put(curWord, localWord2Count.getOrDefault(curWord, word2Count.get(curWord)) - 1);
                    if (localWord2Count.get(curWord) == 0) {
                        wordToInclude--;
                    }
                }
                end += wl;

                while (wordToInclude == 0) { // 满足条件了，
                    if (end - start == wl * N) {
                        result.add(start);
                    }
                    String headWord = s.substring(start, start+wl); // 开始缩减window start
                    if (word2Count.containsKey(headWord)) {
                        localWord2Count.put(headWord, localWord2Count.get(headWord) + 1);
                        if (localWord2Count.get(headWord) > 0) {
                            wordToInclude++;
                        }
                    }

                    start += wl;
                }
            }

            localWord2Count.clear();
        }

        return result;
    }
}
