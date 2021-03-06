package algorithm_twoPointers;

// 做前，想不到什么对space要求比较低的方法


//Hint： What if you fill the longer array from the end instead of start ?
public class LeetCode88_easy_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	
    		int i = m-1;
    		int j = n-1;
    		
    		int k = m+n-1;
    		
    		while (i >= 0 || j >= 0) {
    			if (i < 0) {
    				nums1[k] = nums2[j];
    				j--;
    			} else if (j < 0) {
    				nums1[k] = nums1[i];
    				i--;
    			} else {
    				if (nums1[i] > nums2[j]) {
    					nums1[k] = nums1[i];
    					i--;
    				} else {
    					nums1[k] = nums2[j];
    					j--;
    				}
    			}
    			
    			k--;
    		}
        
    }
}
