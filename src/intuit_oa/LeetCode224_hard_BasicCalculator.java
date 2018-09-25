package intuit_oa;
import java.util.*;

// 1+ （5+ (2-3+4)）
// 只有遇到"("才用到stack，把之前的存起来
public class LeetCode224_hard_BasicCalculator {

    public int calculate(String s) {
        int result = 0, sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { // get the number
                int number = c-'0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    number = number*10 + s.charAt(i+1)-'0';
                    i++;
                }
                System.out.println(number);
                result += sign * number;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);

                // reset for inner parenthesis
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = stack.pop()*result + stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "12"; // "2147483647";
        LeetCode224_hard_BasicCalculator bc = new LeetCode224_hard_BasicCalculator();
        System.out.println(bc.calculate(s));
    }
}
