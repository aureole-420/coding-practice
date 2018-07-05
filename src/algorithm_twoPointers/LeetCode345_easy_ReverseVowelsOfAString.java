package algorithm_twoPointers;

// 思路比较简单，我们是如何reverse一个string/array的 -- 队首队尾指针
// 
//这里差不多，就是加了一个判断。
public class LeetCode345_easy_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
    		if (s == null || s.length() == 0) {
    			return s;
    		}
    		
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        
        while (i < j) {
        		if (!isVowel(arr[i])) {
        			i++;
        			continue;
        		}
        		if (!isVowel(arr[j])) {
        			j--;
        			continue;
        		}
        		
        		char temp = arr[i];
        		arr[i] = arr[j];
        		arr[j] = temp;
        		i++; j--;
        }
        
        return new String(arr);
    }
    
    private boolean isVowel(char c) {
    		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
    			return true;
    		} else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
    			return true;
    		} else {
    			return false;
    		}
    }
}
