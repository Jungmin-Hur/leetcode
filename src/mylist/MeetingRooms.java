/**
 * 252. Meeting Rooms
 * https://leetcode.com/problems/meeting-rooms/
 */
package mylist;

import common.My;

import java.util.Arrays;

@My
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        // for(int i=0; i<intervals.length; i++) {
        //     System.out.print(intervals[i][0]);
        // }
        // System.out.println("");
        Arrays.sort(intervals, (i1, i2) -> i1[0]-i2[0]);

        for(int i=0; i<intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }
}
