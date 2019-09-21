package fall_2019.microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leetcode17_letterCombination {

    public List<String> letterCombinations(String digits) {
        Map<Integer, String> num2String = new HashMap<>();
        num2String.put(2, "abc");
        num2String.put(3, "def");
        num2String.put(4, "ghi");
        num2String.put(5, "jkl");
        num2String.put(6, "mno");
        num2String.put(7, "pqrs");
        num2String.put(8, "tuv");
        num2String.put(9, "wxyz");

        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) return result;
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb,  num2String, result);
        return result;
    }

    private void dfs(String digits, int pos, StringBuilder sb,  Map<Integer, String> num2String, List<String> result) {
        if (pos == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int idx = digits.charAt(pos) - '0';
        System.out.println("idx = " + idx);
        String chars = num2String.get(idx);
        for (char c : chars.toCharArray()) {
            sb.append(c);
            dfs(digits, pos+1, sb, num2String, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
