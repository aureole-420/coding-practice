package topological_sort;


// solution to CourseSchedule using in-degree and out-degree
public class CourseSchedule_InOutDegree {
	
	
	int[][] adjMat;
	int[] inDegree;
	boolean[] isRemoved;
	
	public boolean canFinish(int numC, int[][] preq) {
		// setting attributes
		adjMat = new int[numC][numC];
		inDegree = new int[numC];
        for (int i = 0; i < preq.length; i++) {
        		adjMat[preq[i][0]][preq[i][1]] = 1;
        		inDegree[preq[i][1]]++;
        }
        
        isRemoved = new boolean[numC];
        for (int i = 0; i < numC; i++) {
        		isRemoved[i] = false;
        }
        
        // remove node/edges one by one
        while (pickZeroInDegree() >= 0) {
        		removeNode(pickZeroInDegree());
        }
        
        // check result;
        return allRemoved();
	}
	
	private void removeNode(int n) { // the node n has 0 inDegree, 
		for (int i = 0; i < adjMat[n].length; i++) {
			if (adjMat[n][i] == 0) { // not neighbor node
				continue;
			}
			inDegree[i]--; // remove that edge <n, i>
		}
		isRemoved[n] = true;
	}
	
	private int pickZeroInDegree() { // pick a node with zero degree. return -1 if none;
		for (int i = 0; i < inDegree.length; i++) { 
			if (inDegree[i] == 0 && !isRemoved[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean allRemoved() { // check if all nodes are removed.
		for (int i = 0; i < isRemoved.length; i++) {
			if (isRemoved[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		CourseSchedule_InOutDegree cs = new CourseSchedule_InOutDegree();
		
		int numCourses = 3;
		int[][] prerequisites = new int[3][2];
		prerequisites[0] = new int[] {0, 1};
		prerequisites[1] = new int[] {1, 2};
		prerequisites[2] = new int[] {2, 0};
		System.out.print(cs.canFinish(numCourses, prerequisites));
	}
}
