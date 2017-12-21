package topological_sort;

public class CourseSchedule {
	
	private boolean[] marked;
	private boolean[] inCallStack;
	int[][] adjMat;
	
	public boolean canFinish(int numC, int[][] preq) {
		// transform input prerequisites into an adjacent matrix;
		adjMat = new int[numC][numC];
        for (int i = 0; i < preq.length; i++) {
        		adjMat[preq[i][0]][preq[i][1]] = 1;
        }
        
        marked = new boolean[numC];
        inCallStack = new boolean[numC];
        for (int i = 0; i < numC; i++) {
        		marked[i] = false;
        		inCallStack[i] = false;
        }    
        for (int n = 0; n < numC; n++) {
        		if (marked[n] == true) {
        			continue;
        		}
        		if (dfs(n) == false) {
        			return false;
        		}
        }
        return true;
    }	
	
	private boolean dfs(int n) { // visit the n^{th} node;
		marked[n] = true;
		inCallStack[n] = true;
		for (int i = 0; i < adjMat[n].length; i++) { // check all the neighboring nodes
			if (adjMat[n][i] == 0) { // not neighboring node
				continue;
			}
			if (inCallStack[i] == true) { // neighboring node and currently in CallStack
				System.out.println("node " + i + " is in CallStack");
				return false;
			}
			if (marked[i] == false) { // dfs-ly visit the unmarked nodes
				 if (dfs(i) == false) {
					 return false;
				 }
			}
		}
		inCallStack[n] = false;
		return true;
	}
	
	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		
		int numCourses = 4;
		int[][] prerequisites = new int[4][2];
		prerequisites[0] = new int[] {1, 0};
		prerequisites[1] = new int[] {2, 1};
		prerequisites[2] = new int[] {3, 2};
		prerequisites[3] = new int[] {1, 3};
		System.out.print(cs.canFinish(numCourses, prerequisites));
	}
}
