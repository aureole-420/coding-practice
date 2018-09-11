package facebook_more;

import java.util.*;

public class LeetCode253_medium_MeetingRooms_II {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private class TimeStamp {
        int time;
        boolean isStart;
        TimeStamp(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        List<TimeStamp> list = new ArrayList<>();
        for (Interval interval : intervals) {
            list.add(new TimeStamp(interval.start, true));
            list.add(new TimeStamp(interval.end, false));
        }

        int maxNumRoomUsed = -1;
        int numOfRoomsUsed = 0;
        Collections.sort(list, (a, b) -> {
            if (a.time == b.time) {
                if (!a.isStart) { // a is end
                    return -1;
                }
                if (!b.isStart) { // b is end time
                    return 1;
                }
                else { // both are start time
                    return 0;
                }
            } else {
                return a.time - b.time;
            }
        } );

        for (TimeStamp timeStamp : list) {
            if(timeStamp.isStart) {
                numOfRoomsUsed++;
                maxNumRoomUsed = Math.max(maxNumRoomUsed, numOfRoomsUsed);
            } else {
                numOfRoomsUsed--;
            }
        }

        return maxNumRoomUsed < 0 ? 0 : maxNumRoomUsed;
    }
}
