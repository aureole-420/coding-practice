package facebook;

public class LeetCode38_easy_CountAndSay {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = helper(s);
        }

        return s;
    }

    // count and say from a string e.g. "1", return "11"
    // 111 2222 3333
    private String helper(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length();) {
            int count = 0;
            while (i + count < s.length() && s.charAt(i + count) == s.charAt(i)) {
                count++;
            }

            sb.append(count);
            sb.append(s.charAt(i));

            i = i+ count;
        }

        return sb.toString();
    }
}
