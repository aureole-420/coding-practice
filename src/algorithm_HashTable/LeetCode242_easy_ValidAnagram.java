package algorithm_HashTable;

// 做前： 这题本身很简单，但follow up问string contains unicode --- 不知从和下手

// 做中：follow up里面似乎把unicode当作一个hashmap，但hashmap的类别是？
// 考察的是对hashmap的实现。
public class LeetCode242_easy_ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			alphabet[t.charAt(i) - 'a']--;
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] != 0) {
				return false;
			}
		}
		
		return true;
		
	}
}
