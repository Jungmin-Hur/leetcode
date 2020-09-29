package sample;

import common.Sample;

/**
 * 849. Maximize Distance to Closest Person
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */

@Sample
public class MaxDistToClosest {

    public static void main(String arg[]) {
        System.out.println(maxDistToClosest(new int[]{0,0,0,1,1,0,1,1,0,0,0,1,0,0,1,0,0}));
//        System.out.println(maxDistToClosest(new int[]{0,1,1,1,0,0,1,0,0}));
//        System.out.println(maxDistToClosest(new int[]{0,0,1}));
//        System.out.println(maxDistToClosest(new int[]{0,0,0,1}));
//        System.out.println(maxDistToClosest(new int[]{1,0}));
//        System.out.println(maxDistToClosest(new int[]{0,1}));
//        System.out.println(maxDistToClosest(new int[]{1,0,0,0}));
//        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }

    public static int maxDistToClosest(int[] seats) {
        int maxDist = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        boolean firstOne = false;
        while(true) {
            if(seats[end] == 1) {
                int dist = end - start;
                if(firstOne==false) {
                    firstOne = true; //0부터 시작하고 1이 나오는 경우 end-0 이 distance가
                } else {
                    dist = dist/2; //1 사이에 0인 경우 2로 나눠줘야 함
                }
                if(dist > maxDist) maxDist = dist;

                start = end;
            }
            end++;

            if(end >= seats.length) break;
        }

        if((seats.length-1 - start) > maxDist) { //마지막에 0으로 끝나는 경우에 대한 처리
            maxDist = seats.length-1 - start;
        }
        return maxDist;
    }
}
