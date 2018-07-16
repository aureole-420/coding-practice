package algorithm_HashTable;

import java.util.*;

// 做前： 想到， 排序 + 二分
// 因为刚做过451. sort chars by frequency, 所以用桶排序可以做到O(n) 排序，然后再用二分法

// 做中： 做了半天做不出来，看了答案
// 1. bucket sort 思路是对的，但不用排成O(n),直接排成
// 2. hindex必定小于文章的数量，逆序扫一遍bucket就可以了。
// https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
// 关键是要想到bucket的数量！！！

// e.g [3,0,6,1,5]
// bucket [0 1 2 3 4 5]
// freq   [1 1 0 1 0 2]

public class LeetCode274_medium_Hindex {
	
	public int hIndex(int[] citations) {
	
		int N = citations.length;
		int[] buckets = new int[N+1];
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= N) {
				buckets[N]++;
			} else {
				buckets[citations[i]]++;
			}
		}
		
		int docNum = 0;
		for (int freq = N; freq >= 0; freq--) {
			docNum += buckets[freq];
			if (docNum >= freq) {
				return freq;
			}
		}
		
		// if freq < 0;
		return 0; 

	}
	
//    public int hIndex(int[] citations) {
//    	
//    		// corner case:
//    		if (citations == null || citations.length == 0) {
//    			return 0;
//    		}
//        Arrays.sort(citations);
//        
//        // 二分法，找最后一个满足条件的文档
//        int N = citations.length;
//        int lo = 0, hi = N-1;
//        while (lo+1 < hi) {
//        		int mid = lo + (hi-lo)/2;
//        		int geq = N-mid;
//        		if (geq >= citations[mid]) {
//        			lo = mid;
//        		} else {
//        			hi = mid;
//        		}
//        }
//        
//        int last;
//        if (N-hi >= citations[hi]) {
//        		last = hi;
//        } else if (N-lo >= citations[lo]) {
//        		last = lo;
//        } else {
//        		last = -1;
//        		return
//        }
//        
//        if (last == N-1) {
//        		return citations[last];
//        }
//        // else citations[last], citations[last+1]
//        lo = citations[last]; hi = citations[last+1]-1;
//        int hindex = lo;
//        for (int i = lo; i <= hi; i++) {
//        		if (i > N-lo-1) {
//        			break;
//        		}
//        		hindex = i;
//        }
//        
//        return hindex;
//       
//        
//    }
}
