package fall_2019.microsoft;

import java.util.Arrays;

public class Leetcode805_hard_SplitArrayWithSameAverage {

    public boolean splitArraySameAverage(int[] A) {
        int N = A.length;
        int sum = Arrays.stream(A).sum();
        // if it is possible to ...
        boolean[][][] d = new boolean[N+1][16][30*10000+1]; // n, k, s
        for (int n = 0; n <= N; n++) {
            d[n][0][0] = true;
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= N / 2; k++) {
                for (int s = 1; s <= sum; s++) {
//                    System.out.println(String.format("n=%d, k=%d, s=%d", n, k, s));
                    if (s >= A[n-1]) {
//                        System.out.println("1");
                        d[n][k][s] = d[n-1][k-1][s - A[n-1]] || d[n-1][k][s];
                        System.out.println(String.format("case1: n=%d, k=%d, s=%d,  d[n,k,s]=%B", n, k, s, d[n][k][s]));
                    } else {
                        d[n][k][s] = d[n-1][k][s];
                        System.out.println(String.format("case2: n=%d, k=%d, s=%d, d[n,k,s]=%B", n, k, s, d[n][k][s]));
                    }
                }
            }
        }

        for (int k = 1; k <= N/2; k++) {
            if ((k*sum % N == 0) && d[N][k][k*sum / N]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode805_hard_SplitArrayWithSameAverage sawsa = new Leetcode805_hard_SplitArrayWithSameAverage();
//        int[] A = new int[] {1,2,3};
        int[] A= new int[] {3,1,2};
        boolean res = sawsa.splitArraySameAverage(A);
        System.out.println("res = " + res);
    }
}
