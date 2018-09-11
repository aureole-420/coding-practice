package facebook;


import java.util.*;


// 这题太屌了，从左到右检查一遍多余的closed Parentheses")",
// 再reverse string，检查一遍多余的closed Parentheses"(",
// 每次发现多余close parenthesis，删除任何一个parenthesis
public class LeetCode301_hard_RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    private void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length();i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // we find an extra closed parenthesis we need to remove
                for (int j = jStart; j <=i; j++) {
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j-1) != closedParen)) {
                        System.out.println("j found; " + j);
                        removeHelper(s.substring(0, j) + s.substring(j+1, s.length()), output, i, j, openParen, closedParen);
                    }
                }
                return;
            }
        }



        // no extra closed parenthesis found
        if (closedParen == '(') {
            String reversed = new StringBuilder(s).reverse().toString();
            output.add(reversed);
        } else { // check if there are extra '('
            String reversed = new StringBuilder(s).reverse().toString();
            removeHelper(reversed, output, 0, 0, ')', '(');
        }


}

    public static void main(String[] args) {
        String s = "()())()";
        LeetCode301_hard_RemoveInvalidParentheses rp = new LeetCode301_hard_RemoveInvalidParentheses();
        System.out.println(rp.removeInvalidParentheses(s).size());
    }
}


//class Solution {
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> output = new ArrayList<>();
//        removeHelper(s, output, 0, 0, '(', ')');
//        return output;
//    }
//
//    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
//        int numOpenParen = 0, numClosedParen = 0;
//        for (int i = iStart; i < s.length(); i++) {
//            if (s.charAt(i) == openParen) numOpenParen++;
//            if (s.charAt(i) == closedParen) numClosedParen++;
//            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
//                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
//                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
//                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
//                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
//                return; // Stop here. The recursive calls handle the rest of the string.
//            }
//        }
//        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
//        String reversed = new StringBuilder(s).reverse().toString();
//        if (openParen == '(')
//            removeHelper(reversed, output, 0, 0, ')','(');
//        else
//            output.add(reversed);
//    }
//}