package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.Stack;

public class Lint40_ImplementQueueByTwoStacks {

    public class MyQueue {
        Stack<Integer> stack1, stack2;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            stack2.push(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            if (stack1.isEmpty()) {
                stack2ToStack1();
            }
            return stack1.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            if (stack1.isEmpty()) {
                stack2ToStack1();
            }
            return stack1.peek();
        }

        private void stack2ToStack1() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }
}
