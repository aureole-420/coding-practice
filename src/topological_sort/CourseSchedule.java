package topological_sort;

public class CourseSchedule {
	
	
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// transform a into a adjacent matrices;
		int[][] adjMat = new int[numCourses][numCourses];
        return false;
    }	
	
	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		
		int numCourses = 3;
		int[][] prerequisites = new int[2][2];
		prerequisites[0] = new int[] {0, 1};
		prerequisites[0] = new int[] {1, 2};
		System.out.print(cs.canFinish(numCourses, prerequisites));
	}

}
