package facebook;

// num to 26进
public class LeetCode168_easy_ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int cur = (n-1) % 26;  // 0-25
            sb.insert(0, (char) (cur+'A'));
            n = (n-1) / 26;
        }

        return sb.toString();
    }
}
