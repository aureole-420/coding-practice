package fall_2019.microsoft;

public class leetcode97_interleavingStrings {
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null){
            return false;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        memo = new Boolean[s1.length()+1][s2.length()+1];
        return helper(s1, s2, s3, s1.length(), s2.length());
    }

    // if interleaving first i chars of s1 and first j chars of s2 can be leads to s3.
    // optimization: memoization.
    private boolean helper(String s1, String s2, String s3, int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == 0) {
            memo[i][j] = s2.substring(0, j).equals(s3.substring(0, j));
            return memo[i][j];
        }
        if (j == 0) {
            memo[i][j] = s1.substring(0, i).equals(s3.substring(0, i));
            return memo[i][j];
        }

        boolean result;
        char c1 = s1.charAt(i-1), c2 = s2.charAt(j-1), c3 = s3.charAt(i+j-1);
        if (c3 != c1 && c3 != c2) {
            return false;
        } else if (c3 == c1 && c3 != c2) {
            result = helper(s1, s2, s3, i-1, j);
        } else if (c3 == c2 && c3 != c1) {
            result = helper(s1, s2, s3, i, j-1);
        } else {
            result = helper(s1, s2, s3, i-1, j) || helper(s1, s2, s3, i, j-1);
        }
        memo[i][j] = result;
        return memo[i][j];
    }

    public static void main(String[] args) {
        leetcode97_interleavingStrings ils = new leetcode97_interleavingStrings();
//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        System.out.println(ils.isInterleave(s1, s2, s3));
    }
}
