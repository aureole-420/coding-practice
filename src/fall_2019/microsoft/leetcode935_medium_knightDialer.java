package fall_2019.microsoft;

public class leetcode935_medium_knightDialer {

    private int[][] graph = new int[][]{{4, 6}, {6,8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2,4}};
    private final int MOD = 1000000007;
    public int knightDialer(int N) {
        Integer[][] memo = new Integer[10][N];
        // 1. 定义： memo[i][n], 第n步到第i哥元素共有几种方法
        // 2. 递推关系：
        // memo[i][N] = sum{memo[child][N-1]}
        // 3. 初始条件
        // memo[i][0] = 1;

        for (int i = 0; i < 10; i++) {
            memo[i][0] = 1;
        }

        for (int n = 1; n < N; n++) {
            for (int cur = 0; cur < 10; cur++) {
                int cnt = 0;
                for (int child : graph[cur]) {
                    cnt = (cnt + memo[child][n-1]) % MOD;
                }
                memo[cur][n] = cnt;
            }
        }

        int sum = 0;
        for (int num = 0; num < 10; num++) {
            sum = (sum + memo[num][N-1]) % MOD;
        }

        return sum;
    }
}
