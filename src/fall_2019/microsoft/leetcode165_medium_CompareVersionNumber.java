package fall_2019.microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode165_medium_CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        Queue<Integer> q1 = processVersion(version1);
        Queue<Integer> q2 = processVersion(version2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int num1 = q1.poll();
            int num2 = q2.poll();
            System.out.println("num1="+num1 + " num2=" +num2);
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
            continue;
        }

        while(!q1.isEmpty()) {
            if (q1.poll() == 0){
                continue;
            } else {
                return 1;
            }
        }

        while(!q2.isEmpty()) {
            if (q2.poll() == 0) {
                continue;
            } else {
                return -1;
            }
        }

        return 0;
    }

    private Queue<Integer> processVersion(String version) {
        String[] numbers = version.split("\\."); // 注意正则表达式。
        Queue<Integer> result = new LinkedList<>();
        for (String num : numbers) {
            result.add(parseInt(num));
        }
        return result;
    }

    private int parseInt(String s) {
        System.out.println("s = " + s);
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        if (i == s.length()) return 0;

        String number = s.substring(i, s.length());

        System.out.println("s = " + s + " num=" + number);
        return Integer.parseInt(number);
    }

    public static void main(String[] args) {
        leetcode165_medium_CompareVersionNumber cvn = new leetcode165_medium_CompareVersionNumber();
        cvn.compareVersion("0.1", "1.1");

        System.out.println("parseInt = " + Integer.parseInt("0012"));
    }

}
