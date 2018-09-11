package facebook_more;


// 这题太巧了
// 从两头开始，遇到不相通的就检查内部是否满足palindrome，因为最多删掉一个字母，所以，最多检查一次
public class LeetCode680_easy_ValidPalindrome_II {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return (isPalindromeRange(s, i+1, j) || isPalindromeRange(s, i, j-1));
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isPalindromeRange(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
