package fall_2019.microsoft;

public class LeetCode443_medium_StringCompression {

    public int compress(char[] chars) {
        // corner case

        int N = chars.length;
        int start = 0, end = 0, fill = 0;
        while (start < N) {
            int count = 1;
            while (end + 1 < N && chars[end] == chars[end+1]) {
                end++;
                count++;
            }

            chars[fill++] = chars[start];
            if (count != 1) {
                char[] countArray = Integer.toString(count).toCharArray();
                for (char c : countArray) {
                    chars[fill++] = c;
                }
            }


            start = end + 1;
            end = start;
        }

        return fill;
    }
}
