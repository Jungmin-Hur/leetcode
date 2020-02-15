/**
 * 253. Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
package amore;

import common.A;

import java.util.Arrays;
import java.util.PriorityQueue;

@A
public class MeetingRoomsII {
    //75% using priority queue
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        //priority queue is orderd by end schedules
        PriorityQueue<int[]> pq = new PriorityQueue<>((q1, q2) -> q1[1] - q2[1]);

        int size = intervals.length;
        for(int i=0; i<size; i++) {
            //if new input's start is later than priority queue's first end,
            //priority queue could poll() !!!
            if(!pq.isEmpty() && intervals[i][0] >= pq.peek()[1]) pq.poll();
            pq.add(intervals[i]);
        }
        return pq.size();
    }
    //5% so slow...
    public int minMeetingRoomsOn2(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        for(int i=intervals.length - 1; i >= 0 ; i--) {
            int localmax = 1;
            for(int j = 0; j < i; j++) {
                if(intervals[i][0] < intervals[j][1]) {
                    localmax++;
                }
            }
            res = Math.max(res, localmax);
        }

        return res;
    }
}
