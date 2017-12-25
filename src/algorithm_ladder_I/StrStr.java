package algorithm_ladder_I;

public class StrStr {
	
	public int strStr(String source, String target) {
        // corner case;
		if (source == null || target == null) {
			return -1;
		}
		int sl = source.length();
		int tl = target.length();
		if (sl < tl) {
			return -1;
		}
		
		// two layers of iteration.
		int i, j;
		for (i = 0; i <= sl-tl; i++) {
			for (j = 0; j < tl; j++) {
				char schar = source.charAt(i + j);
				char tchar = target.charAt(j);
				if (schar != tchar) break;
				// else continue;
			}
			if (j == tl) 
				return i;
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		
		
		String source = "abcdabcdefg";
		String target = "bcd";
		
		StrStr ss = new StrStr();
		System.out.println(ss.strStr(source, target)); // expected to be 1
	}
}
