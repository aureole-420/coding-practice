package fall_2019.google;

public class Domino {

    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,6,3,2};
        int[] B = new int[] {2,1,2,2,2,4};

        Domino domino = new Domino();
        System.out.println("result = " + domino.solution(A, B)); // should be 2

//        A = new int[]{1,2,1,2};
//        B = new int[]{2,6,1,2};
//        System.out.println("result = " + domino.solution(A, B)); // should be -1
    }

    public int solution(int[] A, int[] B) {
        if (A.length != B.length) return -1;
        if (A.length == 0) return -1; // e

        int N = A.length;
        int v1 = A[0], v2 = B[0];

        // fA1[i]: the min of rotations needed to have A[0 to i] == v1
        int[] fa1 = new int[N];
        // fA2[i]: the min of rotations needed to have A[0 to i] == v2
        int[] fa2 = new int[N];
        // fB1[i]: the min of rotations needed to have B[0 to i] == v1
        int[] fb1 = new int[N];
        // fB2[i]: the min of rotations needed to have B[0 to i] == v2
        int[] fb2 = new int[N];

        // initialization
        fa1[0] = 0;
        fa2[0] = v1 == v2 ? 0 : 1;
        fb1[0] = v1 == v2 ? 0 : 1;
        fb2[0] = 0;

        int ii = 0;
        System.out.println("--------------------------------------");
        System.out.println(String.format("fa1[%d]=%d", ii, fa1[ii]));
        System.out.println(String.format("fa2[%d]=%d", ii, fa2[ii]));
        System.out.println(String.format("fb1[%d]=%d", ii, fb1[ii]));
        System.out.println(String.format("fb2[%d]=%d", ii, fb2[ii]));

        // transition
        for (int i = 1; i < N; i++) {
            fa1[i] = proceed(fa1, i, A, B, v1);
            fa2[i] = proceed(fa2, i, A, B, v2);
            fb1[i] = proceed(fb1, i, B, A, v1);
            fb2[i] = proceed(fb2, i, B, A, v2);
//            System.out.println("--------------------------------------");
//            System.out.println(String.format("fa1[%d]=%d", i, fa1[i]));
//            System.out.println(String.format("fa2[%d]=%d", i, fa2[i]));
//            System.out.println(String.format("fb1[%d]=%d", i, fb1[i]));
//            System.out.println(String.format("fb2[%d]=%d", i, fb2[i]));

            if (fa1[i] == -1 && fa2[i] == -1 && fb1[i] == -1 && fb2[i] == -1) {
                return -1;
            }
        }

        // result
        int[] candidates = new int[] {fa1[N-1], fa2[N-1], fb1[N-1], fb2[N-1]};
        int minRotations = Integer.MAX_VALUE;
        for (int cand : candidates) {
            if (cand != -1 && cand < minRotations) {
                minRotations = cand;
            }
        }
        return minRotations;
    }

    private int proceed(int[] f, int i, int[] curRow, int[] altRow, int expectedValue) {
        if (f[i-1] == -1) {
            return -1;
        }
        if (curRow[i] == expectedValue) {
           return f[i-1];
        }
        // curRow[i] != expectedValue && altRow[i] == expectedValue
        if (altRow[i] == expectedValue) {
            return f[i-1] + 1;
        }
        // curRow[i] != expectedValue && altRow[i] != expectedValue
        return -1;
    }
}
