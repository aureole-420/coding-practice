package algorithm_twoPointers;
import java.util.*;


// 做前： 1.two hashset 2. sort array然后依次比较，还挺麻烦的

public class LeetCode349_easy_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int elem : nums1) {
        		set1.add(elem);
        }
        
        HashSet<Integer> intersect = new HashSet<>();
        for (int elem : nums2) {
        		if (set1.contains(elem)) {
        			intersect.add(elem);
        		}
        }
        
        int[] result = new int[intersect.size()];
        int i = 0;
        for (int elem : intersect) {
        		result[i] = elem;
        		i++;
        }
        
        return result;
    }
}
