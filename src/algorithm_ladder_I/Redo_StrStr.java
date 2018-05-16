package algorithm_ladder_I;

public class Redo_StrStr {
	
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
		
		int i, j;
		// two layer iteration:
		for (i = 0; i <= sl-tl; i++) {
			for (j = 0; j < tl; j++) {
				char schar = source.charAt(i+j);
				char tchar = target.charAt(j);
				if (schar != tchar) {
					break;
				}
			}
			// found one substring
			if (j == tl) {
				return i;
			}
		}
		
		//never found one.
		return -1;
	}
	
	
	public static void main(String[] args) {
		String source = "abcdefg";
		String target = "def";
		
		Redo_StrStr ss = new Redo_StrStr();
	
		int result = ss.strStr(source, target);
		System.out.println(result); // expect to be 3
		
	}
}
