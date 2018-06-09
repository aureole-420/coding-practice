package algorithm_bfs_dfs;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/description/
// dfs 判断是否在有neighbor在call stack里
// 另一种做法是inDegree，inDegree为0的就是。。。
public class LeetCode210_CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // corner case
    		if (numCourses == 0) {
    			return new int[0];
    		} 
    		
    		if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
    			int[] res = new int[numCourses];
    			for (int i = 0; i < numCourses; i++) {
    				res[i] = i;
    			}
    			return res;
    		}
    		
    		// build a graph
    		
    		ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
    		for (int i = 0; i < numCourses; i++) {
    			graph[i] = new ArrayList<Integer>();
    		}
    		for (int i = 0; i < prerequisites.length; i++) {
    			int preCourse = prerequisites[i][1];
    			int postCourse = prerequisites[i][0];
    			
    			graph[preCourse].add(postCourse);
    		}
    		
    		// dfs graph;
    		List<Integer> postOrder = new ArrayList<Integer>();
    		boolean findCycle = false;
    		boolean[] visited = new boolean[numCourses];
    		boolean[] inCallStack = new boolean[numCourses];
    		for (int k = 0; k < numCourses; k++) {
    			visited[k] = false;
    			inCallStack[k] = false;
    		} 
    		
    		for (int k = 0; k < numCourses; k++) {
    			if (!visited[k]) {
    				if (dfs(graph, visited, inCallStack, k, postOrder)) {
    					findCycle = true;
    					break;
    				}
    			}
    		}
    		
    	    if (findCycle) {
    	    		return new int[0];
    	    } else {
    	    		Collections.reverse(postOrder);
    	    		int[] result = new int[numCourses];
    	    		for (int i = 0; i < postOrder.size(); i++) {
    	    			result[i] = postOrder.get(i);
    	    		}
    	    		
    	    		return result;
    	    }
    		
    }
    
    private boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, boolean[] inCallStack, int k, List<Integer> postOrder) {
    		// base case;
    		inCallStack[k] = true;
    		visited[k] = true;

    		for (int neighbor : graph[k]) {
    			if (visited[neighbor] && inCallStack[neighbor]) {
    				return true;
    			}
    			
    			if (!visited[neighbor]) {
    				boolean findCycle = dfs(graph, visited, inCallStack, neighbor, postOrder);
    				if (findCycle) {
    					return true;
    				}
    			}
    		}
    		
    		postOrder.add(k);
    		
    		inCallStack[k] = false;
    		return false;
    }
    
    public static void main(String[] args) {
    		int[] a = new int[0];
    		
    		System.out.println(a.length);
    }
}
