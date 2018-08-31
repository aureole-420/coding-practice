package facebook;

public class LeetCode13_easy_string_RomanToInteger {

    public int romanToInt(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'I' : sum += 1; break;
                case 'V' : sum += 5; break;
                case 'X' : sum += 10; break;
                case 'L' : sum += 50; break;
                case 'C' : sum += 100; break;
                case 'D' : sum += 500; break;
                case 'M' : sum += 1000; break;
            }
        }

        if (s.indexOf("IV") != -1) sum -= 2;
        if (s.indexOf("IX") != -1) sum -= 2;
        if (s.indexOf("XL") != -1) sum -= 20;
        if (s.indexOf("XC") != -1) sum -= 20;
        if (s.indexOf("CD") != -1) sum -= 200;
        if (s.indexOf("CM") != -1) sum -= 200;

        return sum;
    }

}
