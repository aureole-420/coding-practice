package interviewOA.drawbridge;

//import static org.junit.Assert.assertEquals;
import java.util.*;

public class DegreeOfArray {
	List<Integer> maxOccuranceNumber = new ArrayList<>();
	int maxOccuranceTime = Integer.MIN_VALUE;
	int minLength = Integer.MAX_VALUE;
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> firstIndex = new HashMap<>();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        		if (!count.containsKey(nums[i])) { // first index found;
        			firstIndex.put(nums[i], i);
        		}
        		lastIndex.put(nums[i], i); // update last index.
        		count.put(nums[i], count.getOrDefault(nums[i], 0)+1); // count occurance times.
        }
        
        for (int key : count.keySet()) {
        		if (maxOccuranceTime < count.get(key)) {
        			maxOccuranceNumber.clear();
        			maxOccuranceNumber.add(key);
        			maxOccuranceTime = count.get(key);
        		} else if (maxOccuranceTime == count.get(key)) {
        			maxOccuranceNumber.add(key);
        		}
        }
        
        for (int i : maxOccuranceNumber) {
//        		System.out.println(i);
        		int numOcc = lastIndex.get(i) - firstIndex.get(i)+1;
        		if (numOcc < minLength) {
        			minLength = numOcc;
        		}
        }
        
        return minLength;
    }
    
    public static void main(String[] args) {
    		DegreeOfArray d = new DegreeOfArray();
    		int[] nums = new int[] {1,3,2,2,3,1};
    		int ans = d.findShortestSubArray(nums);
    		System.out.println(ans); // should be 6
//    		assertEquals(ans, 2);
    }
}
