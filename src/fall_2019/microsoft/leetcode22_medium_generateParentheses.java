package fall_2019.microsoft;

import java.util.LinkedList;
import java.util.List;

public class leetcode22_medium_generateParentheses {

    public List<String> generateParenthesis(int n) {
        int leftCount = n, rightCount = n;
        StringBuilder sb = new StringBuilder();
        int sum = 0; // leftparenthesis +1, right -1

        List<String> result = new LinkedList<>();
        helper(n, n, 0, sb, result);
        return result;
    }

    private void helper(int leftCount, int rightCount, int sum, StringBuilder sb, List<String> result) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(sb.toString());
            return;
        }

        if (sum > 0) { // can add either '(' or ')'
            if (leftCount > 0) {
                helper(leftCount-1, rightCount, sum+1, sb.append('('), result);
                sb.deleteCharAt(sb.length()-1);
            }
            helper(leftCount, rightCount-1, sum-1, sb.append(')'), result);
            sb.deleteCharAt(sb.length()-1);
        } else if (sum == 0) { // can only add '('
            helper(leftCount-1, rightCount, sum+1, sb.append('('), result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
