package algorithm_twoPointers;
import java.util.*;


// 比较简单的做法是以较小的那个array来build a hashmap

// https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82243/Solution-to-3rd-follow-up-question
// 如果两个表都很大，那就用external sort， 每次读两个数
public class LeetCode350_easy_IntersectionOfTwoArrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] small, large;
        if (nums1.length < nums2.length) {
        		small = nums1; large = nums2;
        } else {
        		small = nums2; large = nums1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int elem : small) {
        		if (!map.containsKey(elem)) {
        			map.put(elem, 1);
        		} else {
        			map.put(elem, 1+ map.get(elem));
        		}
        }
        
        List<Integer> result = new ArrayList<>();
        for (int elem : large) {
        		if (map.containsKey(elem)) {
        			result.add(elem);
        			if (map.get(elem) == 1) {
        				map.remove(elem);
        			} else {
        				map.put(elem, map.get(elem)-1);
        			}
        		}
        }
        
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
        		res[i] = result.get(i);
        }
        
        return res;
    }
}
