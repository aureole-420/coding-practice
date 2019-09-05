package fall_2019.microsoft;

public class leetcode5_medium_longestPalindromicSubstring {

    public String longestPalindrome(String s) {
        // f[i][j] = f[i+1][j-1] && f[]

        if (s.isEmpty()) {
            return "";
        }
        int N = s.length();
        int count = 0;
        int maxLen = -1;
        String res = null;
        boolean[][] f = new boolean[N][N];
        for (int i = 0; i + 1< N; i++) {
            f[i][i] = true;
            maxLen = 1;
            res = s.substring(i, i+1);
            count++;
            f[i][i+1] = s.charAt(i) == s.charAt(i+1);
            count += f[i][i+1] ? 1 : 0;
            if (f[i][i+1]) {
                maxLen = 2;
                res = s.substring(i, i+2);
            }
        }

        f[N-1][N-1] = true;
        count++;

        for (int j = 2; j < N; j++) {
            for (int i = 0; i < j-1; i++) {
                f[i][j] = f[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                count += f[i][j] ? 1 : 0;
                int len = j - i + 1;
                if (f[i][j] && len > maxLen) {
                    maxLen = len;
                    res = s.substring(i, j+1);
                }

            }
        }

        return res;
    }
}
