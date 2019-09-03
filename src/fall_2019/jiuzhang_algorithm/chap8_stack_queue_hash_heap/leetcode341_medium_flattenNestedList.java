package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;



import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class leetcode341_medium_flattenNestedList {

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }


    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (stack.peek().isInteger()) {
                    return true;
                }

                List<NestedInteger> list = stack.pop().getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }

            return false;
        }
    }
}
