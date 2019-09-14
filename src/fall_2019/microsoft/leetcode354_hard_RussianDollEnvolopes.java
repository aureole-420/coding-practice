package fall_2019.microsoft;

import java.util.Arrays;

public class leetcode354_hard_RussianDollEnvolopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) {
            return 0;
        }

        // sort width,
        Arrays.sort(envelopes, (e1, e2) -> {
           if (e1[0] == e2[0]) {
               return e2[1] - e1[1]; // height descends
           } else {
               return e1[0] - e2[0]; // width ascend
           }
        });

        // longest increasing sequence, O(nlogn) 解法已经不算是dp的解法了。

        int N = envelopes.length;
        int[] tail = new int[N];
        int size = 0;
        for (int[] envelope : envelopes) {
            int idx = Arrays.binarySearch(tail, 0, size, envelope[1]);
            if (idx < 0) {
                idx = -(idx+1);
            }
            tail[idx] = envelope[1];
            if (idx == size) {
                size++;
            }
        }
        return size;
    }
}
