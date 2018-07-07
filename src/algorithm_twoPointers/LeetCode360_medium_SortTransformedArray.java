package algorithm_twoPointers;
import java.util.*;

//做前： google的题果然难！。。。要求O(n)!!!!只想到普通的map和sort
// 
// 做中: 看了答案： 1. 分类画图 2. 这题真的考察对two pointers的理解
// 以a >= 0 为例，现存最大值必为i，j之一，每次可以消去一个 
public class LeetCode360_medium_SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    		int n = nums.length;
        int[] res = new int[n];
//        System.out.println(n + "::"+res.length);
        int i = 0, j = n-1;
        int resIdx = a >= 0 ? n-1 : 0;
       
        
        while (i <= j) {
        		if (a >= 0) {
        			int left = quadTrans(a, b, c, nums[i]);
        			int right = quadTrans(a, b, c, nums[j]);
        			res[resIdx--] = left >= right ? quadTrans(a, b, c, nums[i++]) : quadTrans(a, b, c, nums[j--]);
        		} else {
        			int left = quadTrans(a, b, c, nums[i]);
        			int right = quadTrans(a, b, c, nums[j]);
        			res[resIdx++] = left <= right ? quadTrans(a, b, c, nums[i++]) : quadTrans(a, b, c, nums[j--]);
        		}
        }
        
        return res;
    }
    
    private int quadTrans(int a, int b, int c, int x) {
    		return a*x*x + b*x + c;
    }
    
    public static void main(String[] args) {
    		LeetCode360_medium_SortTransformedArray sta = new LeetCode360_medium_SortTransformedArray();
    		int[] nums = new int[] {-4,-2,2,4};
    		sta.sortTransformedArray(nums, 1,3,5);
    }
}
