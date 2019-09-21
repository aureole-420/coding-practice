package fall_2019.microsoft;

import java.util.HashMap;

public class leetcode10_hard_regularExpressionMatching {

//    // recursive solution
//    public boolean isMatch(String s, String p) {
//        return match(s, p, 0, 0);
//    }
//
//    private boolean match(String s, String p, int sIdx, int pIdx) {
//        if (sIdx == s.length() && pIdx == p.length())
//            return true;
//        if (sIdx < s.length() && pIdx == p.length())
//            return false;
//        if (sIdx == s.length()) {
//            // but p is in "a*" pattern
//            while (pIdx < p.length()) {
//                if (pIdx+1 >= p.length()) return false;
//                char c1 = p.charAt(pIdx);
//                char c2 = p.charAt(pIdx+1);
//                if(c1 != '*' && c2 == '*'){
//                    pIdx += 2;
//                } else {
//                    return false;
//                }
//            }
//            return true;
//        }
//        if (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.') { // current char match
//            if (pIdx+1 < p.length() && p.charAt(pIdx+1)=='*') {
//                return match(s, p, sIdx+1, pIdx) || match(s, p, sIdx, pIdx+2);
//            } else {
//                return match(s, p, sIdx+1, pIdx+1);
//            }
//        } else { // current char doesn't match
//            if (pIdx+1 < p.length() && p.charAt(pIdx+1) == '*') {
//                return match(s, p, sIdx, pIdx+2);
//            } else {
//                return false;
//            }
//        }
//    }

    // memoization solution
    private Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        memo = new Boolean[s.length()+1][p.length()+1];
        return match(s, p, 0, 0);
    }

    boolean getMemo(String s, String p, int i, int j) {
        if (memo[i][j] == null) {
            memo[i][j] =  match(s, p, i, j);
        }
        return  memo[i][j];
    }

    private boolean match(String s, String p, int sIdx, int pIdx) {
        if (sIdx == s.length() && pIdx == p.length())
            return true;
        if (sIdx < s.length() && pIdx == p.length())
            return false;
        if (sIdx == s.length()) {
            // but p is in "a*" pattern
            while (pIdx < p.length()) {
                if (pIdx+1 >= p.length()) return false;
                char c1 = p.charAt(pIdx);
                char c2 = p.charAt(pIdx+1);
                if(c1 != '*' && c2 == '*'){
                    pIdx += 2;
                } else {
                    return false;
                }
            }
            return true;
        }
        if (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.') { // current char match
            if (pIdx+1 < p.length() && p.charAt(pIdx+1)=='*') {
                return getMemo(s, p, sIdx+1, pIdx) || getMemo(s, p, sIdx, pIdx+2);
            } else {
                return getMemo(s, p, sIdx+1, pIdx+1);
            }
        } else { // current char doesn't match
            if (pIdx+1 < p.length() && p.charAt(pIdx+1) == '*') {
                return getMemo(s, p, sIdx, pIdx+2);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        leetcode10_hard_regularExpressionMatching re = new leetcode10_hard_regularExpressionMatching();
        System.out.println(re.isMatch("abc", "a*bc")); // true
        System.out.println(re.isMatch("aabc", "a*abc")); // true
        System.out.println(re.isMatch("", "a*")); // true
        System.out.println(re.isMatch("ab", ".*")); // false

    }
}
