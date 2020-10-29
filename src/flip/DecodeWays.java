/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 */
package flip;

import common.Flip;

@Flip
public class DecodeWays {

    public static void main(String args[]) {
        System.out.println(numDecodings("2")); // 1 - 2
        System.out.println(numDecodings("22")); // 2 - 2,2 22
        System.out.println(numDecodings("226")); // 3 - 2,26 22,6 2,2,6
        System.out.println(numDecodings("2261")); // 3?? - 2,26,1 / 22,6,1 /2,2,6,1
        System.out.println(numDecodings("22611"));
    }

    public static int numDecodings(String s) {
        return 3;
    }
}
