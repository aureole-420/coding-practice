package facebook;

// 这题真是太经典了。
// 每一步都非常好，
// 注意： m 位数 * n 位数， product 最多 m+n位数，所以最高位是不可能进位的。
public class LeetCode43_medium_MultiplyStrings {

    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();

        int[] pos = new int[n+m];

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                // i+j, i+j+1 position
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j) -'0');
                int p1 = i+j, p2 = i+j+1;

                int sum = mul + pos[p2];

                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if ( !(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

}
