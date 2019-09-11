package fall_2019.microsoft;

public class leetcode402_medium_removeKDigits {

    public String removeKdigits(String num, int k) {
        String tempNum = num;
        for (int i = 0; i < k; i++) {
            System.out.println("tempNum =" + tempNum);
            tempNum = removeOneDigit(tempNum);
        }
        return tempNum;
    }

    private String removeOneDigit(String num) {
        if (num.length() == 1) {
            return "0";
        }
        int i = 0;
        while (i < num.length()) {
            if (i+1 < num.length() && num.charAt(i)-'0' <= num.charAt(i+1)-'0') {
                i++;
            } else {
                break;
            }
        }
        String newNum = num.substring(0, i) + num.substring(i+1, num.length());
        return parseInt(newNum);
    }

    private String parseInt(String num) {
        // remove leading zeros;
        int i = 0;
        while (i < num.length()) {
            if (num.charAt(i) != '0') {
                break;
            }
            i++;
        }
        return i == num.length() ? "0" : num.substring(i, num.length());
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println("new String=" + str.substring(0, 0)+str.substring(1,3)+"end");
        System.out.println("new String=" + str.substring(0, 0)+"end");

        leetcode402_medium_removeKDigits rkd = new leetcode402_medium_removeKDigits();
        System.out.println("rkd = " + rkd.removeOneDigit("1"));

        System.out.println("RemoveMultipleDigits = " + rkd.removeKdigits("1432219", 3));
        System.out.println("RemoveMultipleDigits = " + rkd.removeKdigits("10200", 1));
        System.out.println("RemoveMultipleDigits = " + rkd.removeKdigits("112", 1));
    }
}
