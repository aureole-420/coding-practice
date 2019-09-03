package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.Iterator;
import java.util.List;

public class lintcode_540_medium_zigzagIterator {

    public class ZigzagIterator {

        private boolean list1Turn;
        private Iterator<Integer> iter1;
        private Iterator<Integer> iter2;
        /*
         * @param v1: A 1d vector
         * @param v2: A 1d vector
         */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            // do intialization if necessary
            list1Turn = true;
            iter1 = v1.iterator();
            iter2 = v2.iterator();
        }

        /*
         * @return: An integer
         */
        public int next() {
            // write your code here
            if (iter1.hasNext() && iter2.hasNext()) {
                list1Turn = !list1Turn;
                return !list1Turn ? iter1.next() : iter2.next();
            }

            if (iter1.hasNext()) {
                return iter1.next();
            }

                return iter2.next();
        }

        /*
         * @return: True if has next
         */
        public boolean hasNext() {
            // write your code here
            return iter1.hasNext() || iter2.hasNext();
        }
    }
}
