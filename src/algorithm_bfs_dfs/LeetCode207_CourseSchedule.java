package algorithm_bfs_dfs;
import java.util.*;

public class LeetCode207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    		// corner case
    		if (numCourses <= 0 || prerequisites == null) {
    			return false; // actually error.
    		}
    		
        List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
        for (int n = 0; n < numCourses; n++) {
        		graph[n] = new ArrayList<Integer>();
        }
        
        for (int k = 0; k < prerequisites.length; k++) {
        		int preCourse = prerequisites[k][1];
        		int subCourse = prerequisites[k][0];
        		
        		graph[preCourse].add(subCourse);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
        		visited[i] = false;
        		inStack[i] = false;
        }
        
        for (int j = 0; j < numCourses; j++) {
        		if (!visited[j]) {
        			// then visit the 
        			boolean hasCycle = dfs(graph, j, visited, inStack);
        			if (hasCycle) {
        				return false; // cycle found
        			}
        		}
        }
        
        return true; 
    }
    
    // true -- cycle found;
    // false -- otherwise;
    private boolean dfs(List<Integer>[]  graph, int j, boolean[] visited, boolean[] inStack) {
    		visited[j] = true;
    		inStack[j] = true;
    		for (int n : graph[j]) {
    			if (inStack[n]) { // neighbour in Call Stack
    				return true;
    			}
    			
    			if (visited[n]) { // unvisited neighbours
    				if (dfs(graph, n, visited, inStack)) {
    					return true;
    				}
    			}
    		}
    		
    		inStack[j] = false;
    		return false;
    }
    
    public static void main(String[] args) {
    		ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[2];
    		System.out.println(graph[0]);
//    		graph[0].add(123);
    		
    }
}
