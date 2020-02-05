/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
package acomp;

import common.Acomp;

import java.util.Arrays;
import java.util.PriorityQueue;

@Acomp
public class KClosest {
    public static void main(String args[]) {
        kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
    }

    //2020/02/05 version
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((q1, q2)-> (q1[0]*q1[0]+q1[1]*q1[1]) - (q2[0]*q2[0]+q2[1]*q2[1]));

        for(int[] point : points) {
            queue.offer(point);
        }

        int[][] ret = new int[K][2];
        for(int i = 0; i < K; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }

    public int[][] kClosest2(int[][] points, int K) {
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
