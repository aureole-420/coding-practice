package topological_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Course Schedule II differs from course schedule 1 in that
 * a detailed schedule should be returned as well
 */
public class CourseScheduleII {
	// using in degree
	private int[] inDegree;
	private int[][] adjMat;
	private boolean[] isRemoved;
	private List<Integer> result = new ArrayList<Integer>();
			
	public int[] findOrder(int N, int[][] pre) {
        inDegree = new int[N];
        adjMat = new int[N][N];
        isRemoved = new boolean[N];
        for (int i = 0; i < N; i++) {
        		isRemoved[i] = false;
        }
        for (int i = 0; i < pre.length; i++) {
        		adjMat[pre[i][0]][pre[i][1]] = 1;
        		inDegree[pre[i][1]]++;
        }
        
        // remove node/edges one by one
        while (pickZeroInDegree() >= 0) {
        		removeNode(pickZeroInDegree());
        }
        
        System.out.println("result list is of size " + result.size());
        if (result.size() == N) {
        	
        		int[] resultArr = new int[N];
        		int i = 0;
        		for (Integer n : result) {
        			resultArr[i++] = n;
        		}
        		return resultArr;
        }
        
        return new int[N];
    }
	
	private void removeNode(int n) { // the node n has 0 inDegree, 
		for (int i = 0; i < adjMat[n].length; i++) {
			if (adjMat[n][i] == 0) { // not neighbor node
				continue;
			}
			inDegree[i]--; // remove that edge <n, i>
		}
		isRemoved[n] = true;
		result.add(n);
	}
	
	private int pickZeroInDegree() { // pick a node with zero degree. return -1 if none;
		for (int i = 0; i < inDegree.length; i++) { 
			if (inDegree[i] == 0 && !isRemoved[i]) {
				System.out.println("Node i = " + i + " is of 0 indegree.");
				return i;
			}
		}
		System.out.println("no 0 indegree nodes!");
		return -1;
	}
	
	
	public static void main(String[] args) {
		CourseScheduleII cs = new CourseScheduleII();
		
		int numCourses = 3;
		int[][] prerequisites = new int[2][2];
		prerequisites[0] = new int[] {0, 1};
		prerequisites[1] = new int[] {1, 2};
		//prerequisites[2] = new int[] {2, 0};
		System.out.print(cs.findOrder(numCourses, prerequisites));
	}
}
