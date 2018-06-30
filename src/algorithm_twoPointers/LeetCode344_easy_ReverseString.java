package algorithm_twoPointers;

// 做前，这跟two pointers 有什么关系？
// 难道不是先把string变成charArray，然后倒过来？

// 做中，看了一下答案， 前后指针，好处是inplace
public class LeetCode344_easy_ReverseString {
    public String reverseString(String s) {
        if (s == null) {
        		return null;
        }
        
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length-1;
        while (i < j) {
        		char temp = chars[i];
        		chars[i] = chars[j];
        		chars[j] = temp;
        		
        		i++;
        		j--;
        }
        
        return new String(chars);
    }
}
