package expedia_OA;

import java.util.*;


public class ShortestPath {

    // nodes: 1...N
    // from[0] : 1...N
    public List<List<Integer>> findSP(int N, int numRoads, int[] froms, int[] tos, int[] weights) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        // build the graph
        for (int i = 0; i < froms.length; i++) {
            int u = froms[i];
            int v = tos[i];
            int w = weights[i];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // distance  & parent
        Map<Integer, Integer> tempDist = new HashMap<>();
        Map<Integer, Integer> shortestDist = new HashMap<>();
        Map<Integer, List<Integer>> parent = new HashMap<>(); // root node should have no parent
        for (int i = 1; i <= N; i++) {
            parent.put(i, new ArrayList<>());
            tempDist.put(i, Integer.MAX_VALUE);
        }


        // [curDist, node]
        // min dist
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
        pq.offer(new int[]{0, 1});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int dist = cur[0], node = cur[1];
            if (shortestDist.containsKey(node)) {
                continue;
            }

            // this node is done!
            shortestDist.put(node, dist);

            for (int[] temp : graph.get(node)) {
                int neighbour = temp[0];
                int weight = temp[1];

                if (shortestDist.containsKey(neighbour)) {
                    continue;
                }

                if (dist + weight == tempDist.get(neighbour)) {
                    parent.get(neighbour).add(node);
                } else if (dist + weight < tempDist.get(neighbour)) {
                    tempDist.put(neighbour, dist + weight);
                    parent.get(neighbour).clear();
                    parent.get(neighbour).add(node);

                    pq.offer(new int[]{dist + weight, neighbour});
                }
                // else
            }
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(parent, N, new ArrayList<>(), result);

        printResult(result);

        return result;
    }

    // iterate from k
    private void dfs(Map<Integer, List<Integer>> parent, int k, List<Integer> list, List<List<Integer>> result) {
        list.add(0, k);
        if (parent.get(k).size() == 0) {
            result.add(new ArrayList<>(list));
        }

        for (int parentNode : parent.get(k)) {
            dfs(parent, parentNode, list, result);
        }
        list.remove(0);
    }

    public void printResult(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[] from = new int[]{1,2,1,3,1};
        int[] to = new int[]{2,4,3,4,4};
        int[] weight = new int[]{1,1,1,2,2};

        ShortestPath sp = new ShortestPath();
        sp.findSP(4, 5, from, to, weight);
    }
}
