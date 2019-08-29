package algorithm_graph_I;

import java.util.*;

public class MinSpanningTree {

    // undirected edges: [1,2,3], starting from vertex 1 to 2, weighted 3
    // N number of vertices
    public Set<int[]> minSpanningTree(List<int[]> edges, int N) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            List<int[]> listU = graph.getOrDefault(u, new ArrayList<int[]>());
            List<int[]> listV = graph.getOrDefault(v, new ArrayList<int[]>());
            listU.add(edge);
            listV.add(edge);
            graph.put(u, listU);
            graph.put(v, listV);
        }

        Set<Integer> mstNodes = new HashSet<>();
        Set<int[]> mst = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((edge1, edge2) -> {
            return edge1[2] - edge2[2];
        });

        mstNodes.add(0);
        for (int[] edge : graph.get(0)) {
            pq.offer(edge);
        }

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0];
            int v = edge[1];
            int newNode = -1;
            if (!mstNodes.contains(u)) {
                newNode = u;
            } else if (!mstNodes.contains(v)) {
                newNode = v;
            } else {
                continue;
            }

            mstNodes.add(newNode);
            mst.add(edge);
            for (int[] newEdge : graph.get(newNode)) {
                pq.offer(newEdge);
            }
        }

        if (mstNodes.size() == N) {
            return mst;
        } else {
            return new HashSet<int[]>();
        }
    }

    public void printMST(Set<int[]> mst) {
        for (int[] edge : mst) {
            char s = (char) ('A' + edge[0]);
            char e = (char) ('A' + edge[1]);
            System.out.println(s + "-" +e + "::" + edge[2]);
        }
    }


    public static void main(String[] args) {
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0,1,1});
        edges.add(new int[]{0,3,4});
        edges.add(new int[]{0,4,3});
        edges.add(new int[]{1,3,4});
        edges.add(new int[]{1,4,2});
        edges.add(new int[]{2,4,4});
        edges.add(new int[]{2,5,5});
        edges.add(new int[]{3,4,4});
        edges.add(new int[]{4,5,7});

        MinSpanningTree mstObj = new MinSpanningTree();
        Set<int[]> res = mstObj.minSpanningTree(edges, 6);
        mstObj.printMST(res);
    }
}
