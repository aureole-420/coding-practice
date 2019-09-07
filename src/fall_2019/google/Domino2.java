package fall_2019.google;

import java.util.HashMap;
import java.util.HashSet;

public class Domino2 {

    public int solution(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = A.length;
        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            } else {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
                map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            }
        }

        for (int candidate : map.keySet()) {
            if (map.get(candidate) == N) {
                int repeatedTimesInA = 0;
                for (int i = 0; i < N; i++) {
                    if (A[i] == candidate) {
                        repeatedTimesInA++;
                    }
                }
                return Math.min(repeatedTimesInA, N-repeatedTimesInA);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,6,3,2};
        int[] B = new int[] {2,1,2,2,2,4};

        Domino2 domino2 = new Domino2();
        System.out.println("result = " + domino2.solution(A, B)); // should be 2

        A = new int[]{1,2,1,2};
        B = new int[]{2,6,1,2};
        System.out.println("result = " + domino2.solution(A, B)); // should be -1
    }
}
