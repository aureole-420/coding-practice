package algorithm_HashTable;

// 做前：bulls 顺序检查对位字母就可以了， 
// bulls + cows == guess成功猜到的digit
public class LeetCode299_medium_BullsAndCows {
	
    public String getHint(String secret, String guess) {
    	
    		int[] map = new int[10];
    		int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
        		if (secret.charAt(i) == guess.charAt(i)) {
        			bulls++;
        		}
        		map[secret.charAt(i)-'0']++;
        }
        
        int count = 0;
        for (int i = 0; i < guess.length(); i++) {
        		char c = guess.charAt(i);
        		if (map[c-'0'] > 0) {
        			map[c-'0']--;
        			count++;
        		}
        }
        int cows = count - bulls;
        
        return bulls+"A"+cows+"B";
    }
}
