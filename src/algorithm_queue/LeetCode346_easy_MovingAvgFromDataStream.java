package algorithm_queue;

import java.util.*;

// 很显然用dequeue
public class LeetCode346_easy_MovingAvgFromDataStream {

    /** Initialize your data structure here. */
    private Queue<Integer> queue;
    int curSum;
    int size;
    /** Initialize your data structure here. */
    public void MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        curSum = 0;
    }

    public double next(int val) {
        if (queue.size() < size) {
            queue.offer(val);
            curSum += val;
            return curSum * 1.0 / queue.size();
        }

        // size is ...
        curSum = curSum + val - queue.poll();
        queue.offer(val);

        return curSum / queue.size();
    }
}
