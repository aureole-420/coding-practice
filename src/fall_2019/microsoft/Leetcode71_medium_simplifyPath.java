package fall_2019.microsoft;

import java.util.*;

public class Leetcode71_medium_simplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < path.length()) {
            char c = path.charAt(i);
            if (c == '/') {
                i++;
            } else if (c == '.') {
                int start = i;
                while (i < path.length() && path.charAt(i) != '/') {
                    i++;
                }
                String temp = path.substring(start, i);
                if (temp.equals(".")) {
                    //do nothing
                } else if (temp.equals("..")) {
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                } else {
                    stack.push(temp);
                }
            } else { // name:
                int start = i;
                while (i < path.length() && path.charAt(i) != '/') {
                    i++;
                }
                stack.push(path.substring(start, i));
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            list.addFirst(stack.pop());
        }
        String res = "/" + String.join("/", list);
        return res;
    }
}
