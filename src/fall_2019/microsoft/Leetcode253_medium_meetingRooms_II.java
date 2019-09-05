package fall_2019.microsoft;

import java.util.Arrays;

public class Leetcode253_medium_meetingRooms_II {

    public static void printArr(int[][] arr) {
        System.out.println("-----");
        for (int[] subarr : arr) {
            for (int i : subarr) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        int N = intervals.length;
        int[][] events = new int[2*N][2];
        int idx = 0;
        for (int[] itv : intervals) {
            events[idx++] = new int[]{itv[0], 1};
            events[idx++] = new int[]{itv[1], -1};
        }

        Arrays.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int roomCount = 0;
        int maxCount = 0;
        for (int[] event : events) {
            roomCount += event[1];
            if (roomCount > maxCount) {
                 maxCount = roomCount;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{2,1}, {5,6}, {0,2}, {3,4}};

        Leetcode253_medium_meetingRooms_II.printArr(arr);

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        Leetcode253_medium_meetingRooms_II.printArr(arr);
    }
}
