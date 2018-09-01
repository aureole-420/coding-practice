package facebook;
import java.util.*;


// [[1,4],[2,3]] 我有一步处理错了，我以为 [2,3] 会弄出 【1，3】, 但实际排序后 [2,3].end 仍然比[1,4].end更小
// 所以每次更新tail其实是一个Math.max的过程
public class LeetCode56_medium_MergeInterval {

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }


        Collections.sort(intervals, (a, b) -> {return a.start == b.start ? a.end - b.end : a.start-b.start;});



        int head = 0, tail = 0; // initialize them, although we expect the value never being used.
        Iterator<Interval> iter = intervals.iterator();
        if (iter.hasNext()) {
            Interval cur = iter.next();
            head = cur.start;
            tail = cur.end;
        }
        while (iter.hasNext()) {
            Interval cur = iter.next();
            if (cur.start > tail) {
                res.add(new Interval(head, tail));
                head = cur.start;
                tail = cur.end;
            } else {
                tail = Math.max(tail, cur.end);
            }
        }
        res.add(new Interval(head, tail));

        return res;
    }
}
