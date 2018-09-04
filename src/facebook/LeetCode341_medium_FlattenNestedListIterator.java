package facebook;
import java.util.*;


// 这题很巧妙
// 简单的做法是用recursion + queue把它全部展开，

// 巧妙的做法是用stack，每次只展开一点，保证stack head是integer就行
public class LeetCode341_medium_FlattenNestedListIterator {

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    private Deque<NestedInteger> stack = new ArrayDeque<>();
    public void NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size()-1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

//    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

//    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            // else keep 解包
            List<NestedInteger> list  = stack.pop().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }

        return false; // if empty, return false
    }

}
