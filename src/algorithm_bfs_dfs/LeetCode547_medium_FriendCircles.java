package algorithm_bfs_dfs;

//https://leetcode.com/problems/friend-circles/description/
// adj matrix describe an undirected graph
// the goal is to find the strongly connected components of the graph --- 错了，不是strongly connected graph （双向连通，scc用kasaraju algorithms做）
// ---- 这题就是connected components in。。。graph
// 1. dfs: number of islands --- 错了，跟number of islands不一样！
// 2. union find

// https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/


public class LeetCode547_medium_FriendCircles {
    public int findCircleNum(int[][] M) {
    		// corner case;
        if (M == null || M.length == 0 || M[0].length == 0) {
        		return 0;
        }
       
        
        int N = M.length; // number of people
        int[] label = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
        		label[i] = -1;
        		visited[i] = false;
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
        		if (!visited[i]) {
        			System.out.println(i);
        			count++;
        			dfs(M, i, visited);
        		}
        }
        
        return count;
    }
        
    // visit the neighbours of the ith component
    // and recursively dfs the neighbours;
    private void dfs(int[][] M, int i, boolean[] visited) {
    		visited[i] = true;
    		for (int j = 0; j < M[i].length; j++) {
    			if (j != i && M[i][j] == 1) {
    				if (!visited[j]) {
    					visited[j] = true;
    					dfs(M, j, visited);
    				}
    			}
    		} 
    }
    
    public static void main(String[] args) {
    		int[][] a = new int[4][4];
    		a[0] = new int[] {1,0,0,1};
    		a[1] = new int[] {0,1,1,0};
    		a[2] = new int[] {0,1,1,1};
    		a[3] = new int[] {1,0,1,1};
    		
    		LeetCode547_medium_FriendCircles fc = new LeetCode547_medium_FriendCircles();
    		fc.findCircleNum(a);
    }

}
