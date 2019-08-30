package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.LinkedList;

public class Lint495_easy_implementStack {

    public class Stack {

        private LinkedList<Integer> list = new LinkedList<>();
        /*
         * @param x: An integer
         * @return: nothing
         */
        public void push(int x) {
            // write your code here
            list.addLast(x);
        }

        /*
         * @return: nothing
         */
        public void pop() {
            // write your code here
            list.removeLast();
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            return list.peekLast();
        }

        /*
         * @return: True if the stack is empty
         */
        public boolean isEmpty() {
            // write your code here
            return list.isEmpty();
        }
    }
}
