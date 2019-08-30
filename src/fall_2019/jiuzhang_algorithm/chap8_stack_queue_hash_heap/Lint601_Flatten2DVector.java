package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;


import java.util.Iterator;
import java.util.List;

public class Lint601_Flatten2DVector {

    public class Vector2D implements Iterator<Integer> {

        private Iterator<Integer> curIter;
        private Iterator<List<Integer>>  listIter;

        public Vector2D(List<List<Integer>> vec2d) {
            listIter = vec2d.iterator();
            curIter = null;
        }

        @Override
        public Integer next() {
            return curIter.next();
        }

        @Override
        public boolean hasNext() {
            if (curIter == null || !curIter.hasNext()) {
                while (listIter.hasNext()) { // [[],[1,2],[],[3]]
                    List<Integer> curList = listIter.next();
                    curIter = curList.iterator();
                    if (curIter.hasNext()) {
                        return true;
                    }
                }
                return false;
            }

            return true;
        }

        @Override
        public void remove() {
            curIter.next();
        }
    }
}
