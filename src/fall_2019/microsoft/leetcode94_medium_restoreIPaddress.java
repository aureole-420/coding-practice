package fall_2019.microsoft;

import java.util.LinkedList;
import java.util.List;

public class leetcode94_medium_restoreIPaddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        List<String> list = new LinkedList<>();

        dfs(s, 0, list, result);
        return result;
    }

    private void dfs(String s, int pos, List<String> list, List<String> result) {
        if (pos >= s.length()) {
            if (list.size() == 4) {
                result.add(String.join(".", list));
            }
            return;
        }
        // pruning
        if (s.length() - pos > 3 * (4-list.size()) || s.length()-pos < 4-list.size()) {
            return;
        }

        // leading zero
        if (s.charAt(pos) == '0') {
            list.add("0");
            dfs(s, pos+1, list, result);
            list.remove(list.size()-1);
            return;
        }

        // nonleading zero:
        int num = 0;
        for (int i = pos; i < pos+3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) -'0');
            if (num > 255) {
                break;
            }
            list.add(Integer.toString(num));
            dfs(s, i+1, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        leetcode94_medium_restoreIPaddress rp = new leetcode94_medium_restoreIPaddress();
//        List<String> res = rp.restoreIpAddresses("25525511135");
        List<String> res = rp.restoreIpAddresses("301415");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
