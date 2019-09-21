package fall_2019.microsoft;

public class leetcode43_medium_multiplyStrings {

    public String multiply(String num1, String num2) {
        // corner case:
        if (num1 == null ||
                num2 == null ||
                num1.length() == 0 ||
                num2.length() == 0) {
            return "";
        }

        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int plo = i+j+1, phi = i+j;
                int sum = res[plo] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[plo] = sum % 10;
                res[phi] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(num == 0 && sb.length() == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString(); // 注意这个特殊情况。
    }
}
