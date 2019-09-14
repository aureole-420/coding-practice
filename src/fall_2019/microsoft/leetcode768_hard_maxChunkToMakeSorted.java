package fall_2019.microsoft;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode768_hard_maxChunkToMakeSorted {

    /**
     * 两种办法解决，都是greedy，也就是找到chunk就划分，从而达到最大chunk
     * 1。 maxLeft, minRigh, [2 | 1 3 4 4],某个位置能否划分，取决于|左边的数是否小于等于右侧所有的数， |右边的那个数是否大于等于左边所有的数
     * 构造 maxLeft， minRight array，然后依次检车i，i+1元素间是否可以做划分。
     * 2。 sliding window，什么是chunk的条件？chunk的元素内容应该与expected （也就是sorted矩阵那部分）一样，顺序不重要。所以不停的构造window，每次找到一个两者元素完全相同的区间就把这个区间化作chunk
     */
//    public int maxChunksToSorted(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            return 0;
//        }
//        int N = arr.length;
//        int[] leftMax = new int[arr.length];
//        int[] rightMin = new int[arr.length];
//
//        leftMax[0] = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
//        }
//
//        rightMin[N-1] = arr[N-1];
//        for (int i = N-2; i >= 0; i--) {
//            rightMin[i] = Math.min(arr[i], rightMin[i+1]);
//        }
//
//        // check each [i, i+1] boundary
//        int res = 1; //initially a whole chunk
//        for (int i = 0; i+1 < N; i++) {
//            if (rightMin[i+1] >= leftMax[i]) {
//                res++; // every cut add one chunk
//            }
//        }
//        return res;
//    }

    // sliding window
    public int maxChunksToSorted(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        int nonzero = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {

            int x = arr[i], y = expected[i];
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1) nonzero++;
            if (count.get(x) == 0) nonzero--;

            count.put(y, count.getOrDefault(y, 0) - 1);
            if (count.get(y) == 0) nonzero--;
            if (count.get(y) == -1) nonzero++;

            if (nonzero == 0) { // a chunk is found
                res++;
            }
        }

        return res;
    }


}
