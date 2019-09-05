package fall_2019.microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode305_hard_numberOfIslands_II_UNION_FIND {

    private int[][] dxy = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m, n);
        List<Integer> result = new LinkedList<>();
        for (int[] position : positions) {
            int x = position[0], y = position[1];
            int id = x * n + y;
            if (uf.father[id] < 0) { // 处理重复的。。。
                result.add(uf.count);
                continue;
            }

            uf.father[id] = id;
            uf.add(x, y);
            for (int[] distance : dxy) {
                int xx = x + distance[0];
                int yy = y + distance[1];
                int adjId = xx * n + yy;
                if (xx < 0 || yy < 0 || xx >= m || yy >= n || uf.father[adjId] < 0) {
                    continue;
                }
                uf.union(id, adjId);
            }

            result.add(uf.count);
        }

        return result;
    }

    class UnionFind {
        int[] father;
        int count;
        UnionFind(int rows, int cols) {
            father = new int[rows * cols];
            // initially there is no island in the map.
            Arrays.fill(father, -1);
            count = 0;
        }

        void add(int i, int j) {
            count++;
        }

        void union(int node1, int node2) {
            int father1 = find(node1);
            int father2 = find(node2);
            if (father1 != father2) {
                father[father1] = father2;
                count--;
            }
        }

        int find(int node) {
            if (father[node] == node) {
                return node;
            }

            father[node] = find(father[node]);
            return father[node];
        }
    }

}
