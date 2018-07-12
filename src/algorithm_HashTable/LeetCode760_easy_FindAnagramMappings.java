package algorithm_HashTable;
import java.util.*;


// 做前，把B做成表就行了
public class LeetCode760_easy_FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
    	
    		int[] res = new int[A.length];
    		
    		// num: [pos1, pos2]
        HashMap<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
        		int num = B[i];
        		if (!positions.containsKey(num)) {
        			positions.put(num, new LinkedList<Integer>());
        		}
        		positions.get(num).add(i);
        }
        
        for (int j = 0; j < A.length; j++) {
        		int num = A[j];
        		res[j] = positions.get(num).remove(0);
        }
        
        return res;
    }
}
