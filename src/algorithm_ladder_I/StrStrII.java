package algorithm_ladder_I;

/**
 * The same as LintCode 13 but requires O(m+n) Solution
 * One possible solution is Robin-Karp Algorithm
 * 1) Use HashCode use modulation: HashCode(ABCD) = (A*31^3 + B*31^2 + C*31^1 + D*31^0) % BASE (note base as Q)
 *    property of module: (A+B) % Q =  (A % Q + B % Q) % Q
 *    property of module: (A * B) % Q = ((A % Q)*B) % Q
 *    	therefore,
 *    	to obtain (A*31^3 + B*31^2 + C*31^1 + D*31^0) % Q  :
 *    	    1. cal temp = (0*31 + A) % Q 
 *     		2. cal temp = (temp*31 + B) % Q
 *     		3. cal temp = (temp*31 + C) % Q
 *     		4. cal temp = (temp*31 + D) % Q
 * 2) If known (A*31^3 + B*31^2 + C*31^1 + D*31^0) % Q 
 *    how to obtain (B*31^3 + C*31^2 + D*31^1 + E*31^0) % Q
 *    	let x = A*31^3 + B*31^2 + C*31^1 + D*31^0
 *    	let x' = B*31^3 + C*31^2 + D*31^1 + E*31^0
 *    	x' = x*31 + E - A*31^4
 *    	x' % Q = [(x - A*31^3) * 31 + E] % Q
 *    		   = [x % Q + A * (Q - 31^3 % Q) + E] % Q
 *     if (31^3 % Q) = RM is calculated beforehand then
 *      x' % Q = [x % Q + A * (Q - RM) + E] % Q
 *      
 */
public class StrStrII {
	
	
	public int strStr(String haystack, String needle) {
        // corner case:
		if (haystack == null || needle == null) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		
		int Q = 100000;
		int M = needle.length();
		int N = haystack.length();
		
		if (M > N) {
			return -1;
		}
		
		// compute RM
		int RM = 1;
		for (int i = 1; i <= M-1; i++) {
			RM = (RM * 31) % Q;
		}
		
		int hashPattern = getHashCode(needle, Q);
		System.out.println("hashPattern: " + hashPattern);

		
		int hashCompare = getHashCode(haystack.substring(0, M), Q);
		for (int i = 0; i <= N-M; i++) {
			if (i != 0) { // update hashcode
				int originalInit = Character.getNumericValue(haystack.charAt(i-1)); 
				int newEnd = Character.getNumericValue(haystack.charAt(i+M-1));
				hashCompare = (31 * (hashCompare + originalInit * (Q - RM % Q)) + newEnd) % Q;
			}	
			System.out.println("hashCompare: " + hashCompare);
			if (hashCompare == hashPattern) {
				return i;
			} // else continue;
		}
		
		return -1;
    }
	
	private int getHashCode(String s, int Q) {
		char[] chars = s.toCharArray();
		int r = 0; 
		for (char c : chars) {
			r = (r*31 + Character.getNumericValue(c)) % Q;
		}
		return r;
	}
	
	public static void main(String[] args) {
		String haystack = "abcd";
		String needle = "bcd";
		StrStrII ss = new StrStrII();
		System.out.println(ss.strStr(haystack, needle)); // should be 1
	}
	
}
