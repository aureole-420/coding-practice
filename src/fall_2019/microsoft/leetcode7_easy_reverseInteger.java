package fall_2019.microsoft;


public class leetcode7_easy_reverseInteger {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int residue = x % 10; // 不停取mod可以从后往前得到一个数的digit
            x /= 10;
            //根据当前rev和residue来判断下一步是否越界了。
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && residue > Integer.MAX_VALUE%10)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && residue < Integer.MIN_VALUE%10)) {
                return 0;
            }
            rev = rev * 10 + residue; // 不停*10+residue可以根据数字的digit还原一个数字。
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println("residue = " + (Integer.MAX_VALUE % 10));

        System.out.println("residue = " + Integer.MIN_VALUE + " "+ (Integer.MIN_VALUE % 10));

    }
}
