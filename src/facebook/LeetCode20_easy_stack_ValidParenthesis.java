package facebook;

import java.util.*;


public class LeetCode20_easy_stack_ValidParenthesis {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char lastChar = stack.peek();
                if (
                        (lastChar == '(' && c == ')') ||
                        (lastChar == '[' && c == ']') ||
                        (lastChar == '{' && c == '}')
                        ) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.size() == 0;
    }

}
