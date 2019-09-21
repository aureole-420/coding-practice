package fall_2019.airbnb;

import java.util.*;

public class oa_divide { // leetcode 161

    //
    public String fractionToDecimal(int numerator, int denominator) {
        // integer part:
        int intPart = numerator / denominator;
        long residue = numerator % denominator;
        if (residue == 0L) {
            return Integer.toString(intPart);
        }

        // non zero faction part: residue / denominator
        List<Integer> digits = new ArrayList<>();
        Map<Long, Integer> residue2Index = new HashMap<>();

        int curIndex = 0;
        boolean cycleFound = false;
        int cycleStartIdx = -1, cycleEndIdx = -1;
        while (residue != 0) {
            System.out.println("residue = " + residue);
            if (residue < denominator) {
                residue *= 10;
                digits.add(0);
                curIndex++;
            } else {
                int curDigit = (int)(residue / denominator);
                digits.add(curDigit);
                residue2Index.put(residue, curIndex);
                residue = residue % denominator;
                if (residue2Index.containsKey(residue)) {
                    cycleFound = true;
                    cycleStartIdx = residue2Index.get(residue);
                    cycleEndIdx = curIndex;
                    break;
                }
                curIndex++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(intPart));
        sb.append('.');
        if (!cycleFound) {
            for (int digit : digits) {
                sb.append('0' + digit);
            }
            return sb.toString();
        } else {
            for (int i = 0; i < cycleStartIdx; i++) {
                sb.append('0' + digits.get(i));
            }
            sb.append('(');
            for (int i = cycleStartIdx; i <= cycleEndIdx; i++) {
                sb.append('0' + digits.get(i));
            }
            sb.append(')');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        oa_divide od = new oa_divide();
        System.out.println(od.fractionToDecimal(5, 13));
    }
}
