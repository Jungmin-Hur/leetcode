/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
package amazon;

import common.Amazon;

import java.util.Arrays;

@Amazon
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        long[] dist = new long[points.length];
        for(int i=0; i<points.length; i++) {
            dist[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }

        Arrays.sort(dist);
        long k = dist[K-1];

        int[][] retVal = new int[K][2];
        int index = 0;
        for(int i=0; i<points.length; i++) {
            if((points[i][0]*points[i][0] + points[i][1]*points[i][1]) <= k) {
                retVal[index] = points[i];
                index++;

                if(index >= K) break;
            }
        }

        return retVal;
    }
}
