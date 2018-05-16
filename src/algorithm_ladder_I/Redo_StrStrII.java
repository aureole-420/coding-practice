package algorithm_ladder_I;


// Robin-karp algorithm
// 0. 中心思想：比较hashcode，滑动窗口，char增一减一利用先前计算hashcode的值，避免重复计算hashcode
// 1. char to int conversion: 两种方式：1.直接getASCIIvalue 2.用Character.getNumericValue() https://www.javatpoint.com/java-char-to-int
// 2. 核心：update hashcode：
//     已知 ABC的hashcode ==> O(1) complexity for BCD的hashcode

// given a string "ABC"
// x = A*31^2 + B*31^1 + C * 31^0
// given a string "BCD"
// x' = (31*x) + D - A * 31^3
// therefore:
// x' % Q = (31 * (x%Q) + D + A * (Q-RM)) % Q
// where RM = 31^3 % Q
public class Redo_StrStrII {
	
	public int strStr(String source, String target) {
		// corner case:
		if (source == null || target == null) {
			return -1;
		}
		int sl = source.length();
		int tl = target.length();
		if (sl < tl) {
			return -1;
		}
		
		int Q = 1000000;
		int targetHashValue = getHashValue(target, Q);
		int sourceHashValue = 0;
		
		int RM = 0;
		for (int i = 0; i < tl; i++) {
			if (i == 0) {
				RM = 31 % Q;
			} else {
				RM = (31 * RM) % Q;
			}
		}
		
		// iterating through source
		for (int i = 0; i <= sl-tl; i++) {
			if (i == 0) {
				sourceHashValue = getHashValue(source.substring(i, i+tl), Q);
			} else {
				sourceHashValue = (31*sourceHashValue + source.charAt(i+tl-1) + source.charAt(i-1) * (Q - RM) ) % Q;
			}
			// found a match
			if (sourceHashValue == targetHashValue) {
				return i;
			}
			// else continue;
		}
		
		// not found
		return -1;
		
	}
	
	
	private int getHashValue(String s, int Q) {
		char[] charArr = s.toCharArray();
		int res = 0;
		for (char cc : charArr) {
			res = (31 * res + cc) % Q;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		
		String source = "aaaabfcdabcdefg";
		String target = "bcdf";
		
		Redo_StrStrII ss = new Redo_StrStrII();
		System.out.println(ss.strStr(source, target)); // expected to be 1
	}
}
