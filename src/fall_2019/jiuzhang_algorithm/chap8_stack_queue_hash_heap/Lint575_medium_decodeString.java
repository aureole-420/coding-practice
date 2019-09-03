package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

public class Lint575_medium_decodeString {


    public String expressionExpand(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder completed = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }

                numStack.push(num);
                strStack.push("");
                continue;
            } else if (s.charAt(i) == '[') {
                i++;
            } else if (Character.isAlphabetic(s.charAt(i))) {
                StringBuilder localStringBuilder = new StringBuilder();
                while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
                    localStringBuilder.append(s.charAt(i));
                    i++;
                }
                String localStr = localStringBuilder.toString();
                if (strStack.isEmpty()) {
                    completed.append(localStr);
                } else {
                    strStack.push(strStack.pop() + localStr);
                }
                continue;
            } else if (s.charAt(i) == ']') {
                String localString = repeatString(strStack.pop(), numStack.pop());
                if (strStack.isEmpty()) {
                    completed.append(localString);
                } else {
                    strStack.push(strStack.pop() + localString);
                }
                i++;
                continue;
            }
        }

        return completed.toString();
    }

    private String repeatString(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
