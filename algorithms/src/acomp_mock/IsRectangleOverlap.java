/**
 * 836. Rectangle Overlap
 * https://leetcode.com/problems/rectangle-overlap/
 */
package acomp_mock;

import common.Acomp;
import common.MockTest;

@Acomp
@MockTest
public class IsRectangleOverlap {

    public static void main(String args[]) {
        System.out.println(isRectangleOverlap(new int[]{4,4,14,7}, new int[]{4,3,8,8}));
//        System.out.println(isRectangleOverlap(new int[]{2,17,6,20}, new int[]{3,8,6,20})); //true
//        System.out.println(isRectangleOverlap(new int[]{5,15,8,18}, new int[]{0,3,7,9})); //false
//        System.out.println(isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20}));
//        System.out.println(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1})); //false
//        System.out.println(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
//        System.out.println(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{2,2,2,3})); //false
    }

    //TODO 완성되지 않음! 오류 아직 있음..
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int r1_startx = rec1[0];
        int r1_endx = rec1[2];
        int r1_starty = rec1[1];
        int r1_endy = rec1[3];
        if(r1_startx > r1_endx) {
            int temp = r1_startx;
            r1_startx = r1_endx;
            r1_endx = temp;
        }
        if(r1_starty > r1_endy) {
            int temp = r1_starty;
            r1_starty = r1_endy;
            r1_endy = temp;
        }

        int r2_startx = rec2[0];
        int r2_endx = rec2[2];
        int r2_starty = rec2[1];
        int r2_endy = rec2[3];
        if(r2_startx > r2_endx) {
            int temp = r2_startx;
            r2_startx = r2_endx;
            r2_endx = temp;
        }
        if(r2_starty > r2_endy) {
            int temp = r2_starty;
            r2_starty = r2_endy;
            r2_endy = temp;
        }


        if(r2_startx > r1_startx) { //1번이 2번보다 왼쪽에 있을 경우
            if(r1_endx <= r2_startx) return false;
        } else if(r2_startx == r1_startx) {
            if(r1_endx < r2_endx) return false; //같은 경우 끝점이 포함관계여야
        } else{ //2번이 1번보다 오른쪽에 있을 경우
            if(r1_endx >= r2_endx) return false;
        }
        if(r2_starty > r1_starty) { //1번이 2번보다 아래에 있을 경우
            if(r1_endy <= r2_starty) return false;
        } else if(r2_starty == r1_starty) {
            if(r1_endy < r2_endy) return false;
        } else {
            if(r1_endy > r2_endy) return false;
        }

        return true;
    }
}
