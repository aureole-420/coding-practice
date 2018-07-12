package algorithm_HashTable;

// 做前： 每个质数处以比sqrt(num)小的质数都 mod = 0  O(sqrt(n)n)

// 做中：看了答案，思路很厉害！每发现一个prime就把所有倍数都set成true
// 用除法的思想会有很多不必要的计算，
// 用乘法的思想搞笑，因为prime的倍数一定不是prime！ ---- 具体complexity难算，但guarantee O(n^2)
public class LeetCode204_easy_CountPrimes {
	
	public int countPrimes(int n) {
		boolean[] notPrime = new boolean[n]; // less than n, so 1, ... , n-1; initially every number is assumed to be prime.
		int count = 0;
		
		// check from i,
		for (int i = 2; i < n; i++) {
			
			// if it is prime number
			if (!notPrime[i]) {
				count++;
				
				// the j times 
				for (int j = 2; j * i < n; j++) {
					notPrime[j*i] = true;
				}
			}
		}
		
		return count;
	}
}
