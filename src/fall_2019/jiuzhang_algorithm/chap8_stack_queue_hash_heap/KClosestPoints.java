package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }

    public Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {

            @Override
            public int compare(Point p1, Point p2) {
                int dx1 = p1.x - origin.x;
                int dy1 = p1.y - origin.y;
                int distance1 = dx1 * dx1 + dy1 * dy1;

                int dx2 = p2.x - origin.x;
                int dy2 = p2.y - origin.y;
                int distance2 = dx2 * dx2 + dy2 * dy2;

                if (distance1 != distance2) {
                    return distance1 - distance2;
                }

                if (p1.x != p2.x) {
                    return p1.x - p2.x;
                }

                return p1.y - p2.y;
            }
        });

        for (Point p : points) {
            pq.add(p);
        }

        Point[] result = new Point[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }


//    public Point[] kClosest(Point[] points, Point origin, int k) {
//        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
//
//            @Override
//            public int compare(Point p1, Point p2) {
//                int dx1 = p1.x - origin.x;
//                int dy1 = p1.y - origin.y;
//                int distance1 = dx1 * dx1 + dy1 * dy1;
//
//                int dx2 = p2.x - origin.x;
//                int dy2 = p2.y - origin.y;
//                int distance2 = dx2 * dx2 + dy2 * dy2;
//
//                if (distance1 != distance2) {
//                    return distance1 - distance2;
//                }
//
//                if (p1.x != p2.x) {
//                    return p1.x - p2.x;
//                }
//
//                return p1.y - p2.y;
//            }
//        });
//
//        for (Point p : points) {
//            pq.add(p);
//        }
//
//        Point[] result = new Point[k];
//
//        for (int i = 0; i < k; i++) {
//            result[i] = pq.poll();
//        }
//
//        return result;
//    }
}
