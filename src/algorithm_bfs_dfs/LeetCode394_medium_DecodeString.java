package algorithm_bfs_dfs;
import java.util.*;

// https://leetcode.com/problems/decode-string/discuss/87556/Java-short-and-easy-understanding-solution-using-stack
// 思路还是对的，确实跟cs61b的计算器解法是一样的。
// 自己想复杂了，不需要把结果拿出stack


public class LeetCode394_medium_DecodeString {
	
	public String decodeString(String s) {
			Stack<Integer> nStack = new Stack<>(); // stack for operator n
			Stack<String> strStack = new Stack<>(); // stack for string
//			Queue<Character> queue = new LinkedList<>();
//			
//			for (char c : s.toCharArray()) {
//				queue.offer(c);
//    			}
			
			strStack.push(""); // 最重要的，在strStack要先放一个空string“”，这样每次repeat的结果就可以安心直接和前一个string相加了
			
			int i = 0;
			while (i <  s.length()) {
				char c = s.charAt(i);
				
				if (isDigit(c) ) {
					StringBuilder sb = new StringBuilder();
					sb.append(c);
					while (isDigit(s.charAt(i+1))) {
						sb.append(s.charAt(i+1));
						i++;
					}
					nStack.push(Integer.parseInt(sb.toString()));
				}
				
				else if (c == '[') {
					strStack.push("");
				}
				else if (c == ']') {
				
					int n = nStack.pop();
					String str = strStack.pop();
					StringBuilder sb = new StringBuilder();
		    			for (int ii = 0; ii < n; ii++) {
		    					sb.append(str);
		    				}
					strStack.push(strStack.pop() + sb.toString());
				} 
				
				else { // normal char
					strStack.push(strStack.pop() + c);
				}
				
				i++;
			}
			
			return strStack.pop();
	}
//    public String decodeString(String s) {
//    		// corner case;
//        if (s == null || s.length() == 0) {
//            return "";
//        }
//        
//        Deque<Integer> nStack = new ArrayDeque<>(); // stack for operator n
//        Deque<String> strStack = new ArrayDeque<>(); // stack for string
//        Queue<Character> queue = new LinkedList<>();
//        
//        for (char c : s.toCharArray()) {
//        		queue.offer(c);
//        }
//        
//        boolean noRepeat = true;
//        String result = "";
//        
//        while (!queue.isEmpty()) {
//        		char c = queue.poll();
//        		
//        		// deal with digit
//        		if (isDigit(c)) {
//        			StringBuilder sb = new StringBuilder();
//        			sb.append(c);
//        			while (!queue.isEmpty() && isDigit(queue.peek())) {
//        				sb.append(queue.poll());
//        			}
//        			int n = Integer.parseInt(sb.toString());
//        			nStack.push(n);
//        			
//        			System.out.println(n);
//        		}
//        		
//        		// deal with normal characters
//        		else if (isNormalChar(c)) {
//        			StringBuilder sb = new StringBuilder();
//        			sb.append(c);
//        			while (!queue.isEmpty() && isNormalChar(queue.peek())) {
//        				sb.append(queue.poll());
//        			}
//        			String str = sb.toString();
//        			
//        			
//        			if (noRepeat) { // if no repeat
//        				if (nStack.isEmpty()) { // 如果没有嵌套的运算了！
//        					result += str;
//        				} else {
//        					// e.g. 2[2[y]]
//        					strStack.push(strStack.isEmpty() ? str : strStack.pop() + str);
//        				}
//        			} else {
//        				strStack.push(strStack.isEmpty() ? str : strStack.pop() + str);
//        			}
//        			
//        			System.out.println("noRepeat? " + noRepeat + " " + str);
//        		}
//        		
//        		// implement string repetition
//        		else if (c == ']') {
//        			String repeatedString = repeatString(nStack.pop(), strStack.pop());
//        			if (nStack.isEmpty()) {
//        				result += repeatedString;
//        			} else {
//        				strStack.push(strStack.isEmpty() ? repeatedString : strStack.pop() + repeatedString);
//        			}
//        			
//        			
//        			// "n[...]abc" then "abc" is not repeated
//        			if (!queue.isEmpty() && isNormalChar(queue.peek())) {
//        				noRepeat = true;
//        			}
//        		}
//        		// deal with c == '['
//        		else if (c == '['){
//        			strStack.offer("");
//        			noRepeat = false;
//        		}
//        }
//        
//        
//        
//        System.out.println(nStack.size()); // should be 0;
//        System.out.println(strStack.size()); // should be 1;
//        
//        return result;
//    }
    
    
    private boolean isDigit(char c) {
    		if (c >= '0' && c <= '9') {
    			return true;
    		}
    		return false;
    }
    
    private boolean isNormalChar(char c) {
    		if (!isDigit(c) && c != '[' && c != ']') {
    			return true;
    		}
    		return false;
    }
    
    // repeat String str for n times;
    // n operator
    // str: String to repeat
    private String repeatString(int n, String str) {
    		StringBuilder sb = new StringBuilder();
    		for (int i = 0; i < n; i++) {
    			sb.append(str);
    		}
    		return sb.toString();
    }
    
    public static void main(String[] args) {
    		LeetCode394_medium_DecodeString ds = new LeetCode394_medium_DecodeString();
//    		String s = "3[z]2[2[y]pq]ef";
//    		String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
    		String s = "2[2[y]pq1[10[j]]]"; // yypqjjjjjjjj yypqjjjjjjjj
    		System.out.println(ds.decodeString(s));
    }
}
