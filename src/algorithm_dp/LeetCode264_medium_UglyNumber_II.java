package algorithm_dp;

// 想到把7，11， 13。。。的倍数除去即可

// 看了答案，把我的想法取补！！！
// ugly number就是2，3，5的倍数，maintain三个序列，然后做merge sort

// 做后：这个mergesort比较tricky，感觉可以学一下。
public class LeetCode264_medium_UglyNumber_II {
	
    public int nthUglyNumber(int n) {
    	
    	
        int[] arr = new int[n];
        arr[0] = 1;
        
//        int factor2 = 2, factor3 = 3, factor5 = 5;
//        for (int i = 1; i < n; i++) {
//        	int curUglyNum = Math.min(factor2, Math.min(factor3, factor5));
//        	arr[i] = curUglyNum;
//        	
//        	if (curUglyNum == factor2) { 
//        		factor2 *= 2;
//        	} 
//        	if (curUglyNum == factor3) {
//        		factor3 *= 3;
//        	}
//        	if (curUglyNum == factor5) {
//        		factor5 *= 5;
//        	} 
//        }
        
        // 看了答案下的一个解说：
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int seq2 = 1, seq3 = 1, seq5 = 1;
        for (int i = 0; i < n; i++) {
        	arr[i] = Math.min(seq2, Math.min(seq3, seq5)); // min of the 3 sequences is the ith UglyNumber 
        	// arr[idx2] 对应于上一个2的倍数的ugly number
        	if (seq2 == arr[i]) seq2 = 2*arr[idx2++]; //the ith UglyNumber is in factor2 sequence, then update sequence2 
        	if (seq3 == arr[i]) seq3 = 3*arr[idx3++];
        	if (seq5 == arr[i]) seq5 = 5*arr[idx5++];
        }
        return arr[n-1];
    }
}
