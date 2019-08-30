package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Lint486_MergeKSortedArrays {

    class NumInArray {
        int arrIdx;
        int numIdx;
        NumInArray(int ai, int ni) {
            this.arrIdx = ai;
            this.numIdx = ni;
        }
    }

    public int[] mergekSortedArrays(int[][] arrays) {
        PriorityQueue<NumInArray> pq = new PriorityQueue<>((a, b) -> arrays[a.arrIdx][a.numIdx] - arrays[b.arrIdx][b.numIdx]);
        int N = arrays.length;
        for (int i = 0; i < N; i++) {
            if (arrays[i].length != 0) {
                pq.add(new NumInArray(i, 0));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            NumInArray cur = pq.poll();
            result.add(arrays[cur.arrIdx][cur.numIdx]);

            int[] curArr = arrays[cur.arrIdx];
            if (cur.numIdx + 1 < curArr.length) {
                pq.add(new NumInArray(cur.arrIdx, cur.numIdx + 1));
            }
        }

        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}
