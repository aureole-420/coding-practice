package facebook_more;

import java.util.*;

// 做前： 用stack？
// 做后： 做错啦！https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
// 这题跟有括号的还是不一样，还是要转化成 +， 比如负号的就加

public class LeetCode227_medium_BasicCalculator_II {

    public int calculate(String s) {
        Deque<Integer> operands = new ArrayDeque<>();
//        Deque<Character> operators = new ArrayDeque<>();


        int num = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { // c is digit
                num = num*10 + s.charAt(i) - '0';
            }


            // not digit
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1) { // 1. isoperator 2. end of string
                if (operator == '+') {
                    operands.push(num);
                }
                if (operator == '-') {
                    operands.push(-num);
                }
                if (operator == '*') {
                    operands.push(operands.pop() * num);
                }
                if (operator == '/') {
                    operands.push(operands.pop() / num);
                }

                operator = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        while (!operands.isEmpty()) {
            res += operands.pop();
        }

        return res;
    }

    private boolean isOperator(char c) {
        return c == '*' || c == '/' || c =='+' || c == '-';
    }


    public static void main(String[] args) {
        LeetCode227_medium_BasicCalculator_II bc = new LeetCode227_medium_BasicCalculator_II();
        System.out.println(bc.calculate("3+5/2-2")); // should be 3
        System.out.println(bc.calculate("1-1+1")); // should be 1
    }

}
