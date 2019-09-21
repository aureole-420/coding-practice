package fall_2019.microsoft;

import java.util.HashMap;

public class leetcode44_hard_wildCardMatching {
// memoization with hashmap 178ms
//    private HashMap<String, Boolean> memo;
//    public boolean isMatch(String s, String p) {
//        memo = new HashMap<>();
//        return match(s, p, 0, 0);
//    }
//
//    private boolean match(String s, String p, int sIdx, int pIdx) {
//        if (memo.get(sIdx+"."+pIdx) != null) {
//            return memo.get(sIdx+"."+pIdx);
//        }
//        System.out.println(String.format("sIdx=%d, pIdx=%d", sIdx, pIdx));
//        if (sIdx == s.length() && pIdx == p.length())
//            return true;
//        if (sIdx < s.length() && pIdx == p.length())
//            return false;
//        if (sIdx == s.length() && pIdx < p.length()) {// s ="", p = "****"
//            while (pIdx < p.length()) {
//                if (p.charAt(pIdx) != '*') return false;
//                pIdx++;
//            }
//            return true;
//        }
//
//        if (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?') {
//            boolean result = match(s, p, sIdx+1, pIdx+1);
//            memo.put(sIdx+"."+pIdx, result);
//            return result;
//
//        } else {
//            if (p.charAt(pIdx) == '*') {
//                boolean result =  match(s, p, sIdx+1, pIdx+1) // use * for one char
//                        || match(s, p, sIdx, pIdx+1) // doesn't use *
//                        || match(s, p, sIdx+1, pIdx);
//                memo.put(sIdx+"."+pIdx, result);
//                return result;
//            }
//            boolean result = false;
//            memo.put(sIdx+"."+pIdx, result);
//            return result;
//        }
//    }

//


    public boolean isMatch(String s, String p) {
        // state dp[i][j] s[i] matches with s[j]
        // transition
        // if (s[i] == p[j] || p[j]== '?') dp[i,j] = dp[i-1, j-1];
        // else if (p[j] == '*') dp[i,j] == dp[i,j] = dp[i-1,j-1] || dp[i, j-1] || dp[i-1, j]
        // else dp[i, j] = false;

        // initial dp[0,0] = true, dp[i, 0] = false, dp[0, j] unless p="*****";
        // result: dp[s.length, p.length]

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // init:
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++)
            dp[i][0] = false;

        boolean allStar = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j-1) != '*') {
                allStar = false;
            }
            dp[0][j] = allStar;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        leetcode44_hard_wildCardMatching wm = new leetcode44_hard_wildCardMatching();
        System.out.println(wm.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
                "a*******b"));
    }
}
