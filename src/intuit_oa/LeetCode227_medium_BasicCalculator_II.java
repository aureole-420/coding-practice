package intuit_oa;

import java.util.Deque;
import java.util.*;

// 重做一遍，这次用lc224的思路做

// 哇这次思路清晰多了
// 1。 延续lc224， stack并不是什么时候都用，lc224是遇到open parenthesis 就用stack， 这里是遇到新的数字就处理一下，并且存起来
// 2。存起来的都是需要相加的
// 3。 +-优先级低于 */,只有遇到乘除才需要pop，不然都先push进去，-号作为符号带进去数里面去
// 4。 用while语句把整个number取出大大简化
public class LeetCode227_medium_BasicCalculator_II {

    public int calculate(String s) {

        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) { // find the number
                int number = c - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    number = 10*number + s.charAt(i+1)-'0';
                    i++;
                }
                // TODO: do something with number
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1*number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    // may need to handle error
                    stack.push(stack.pop() / number);
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                sign = c;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
