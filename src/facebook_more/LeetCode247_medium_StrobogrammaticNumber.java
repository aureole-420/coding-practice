package facebook_more;
import java.util.*;

// note corner case:
public class LeetCode247_medium_StrobogrammaticNumber {

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        boolean isEven = n % 2 == 0;
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put('0', '0');
        pairs.put('1', '1');
        pairs.put('8', '8');
        pairs.put('6', '9');
        pairs.put('9', '6');

        // e.g n = 3, halfLen = n+1/2= 2
        //  n = 4, halfLen = n+1/2= 2;
        backtrack(result, sb, 0, n, (n+1)/2, isEven, pairs);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int idx, int halfLen, int n, boolean isEven, HashMap<Character, Character> pairs) {
        if (idx >= halfLen) {
            // TODO: add to result if satisfied.
            // TODO: process sb. to make it length n
            if (n != 1 && sb.charAt(0) == '0') return;
            if (!isEven && (sb.charAt(sb.length()-1) == '6' ||sb.charAt(sb.length()-1) == '9' )) {
                return;
            }

            StringBuilder tempSB = new StringBuilder(sb.toString());
            for (int start = isEven ? halfLen-1 : halfLen-2; start >= 0; start--) {
                tempSB.append(pairs.get(tempSB.charAt(start)));
            }
            result.add(tempSB.toString());
            return;
        }

        for (char c : pairs.keySet()) {
            sb.append(c);
            backtrack(result, sb, idx+1, halfLen, n, isEven, pairs);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        LeetCode247_medium_StrobogrammaticNumber sn = new LeetCode247_medium_StrobogrammaticNumber();
        sn.findStrobogrammatic(3);
    }

}
