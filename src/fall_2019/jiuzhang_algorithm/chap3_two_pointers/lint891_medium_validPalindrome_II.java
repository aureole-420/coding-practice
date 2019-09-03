package fall_2019.jiuzhang_algorithm.chap3_two_pointers;


//https://www.lintcode.com/problem/valid-palindrome-ii/description
public class lint891_medium_validPalindrome_II {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else {
                break;
            }
        }

        return isSubPalindrome(s, left, right-1) || isSubPalindrome(s, left + 1, right);
    }


    public boolean isSubPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
