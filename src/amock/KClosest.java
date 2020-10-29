package amock;

import common.A;
import common.Sample;

import java.util.PriorityQueue;

@A
@Sample
public class KClosest {
    public static void main(String args[]) {
        int[][] ans = kClosest(new int[][]{{1,3}, {-2,2}}, 1);
        for(int[] a : ans) {
            System.out.println(a[0]+ "," + a[1]);
        }
    }
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((q1, q2) ->
                ((q1[0] * q1[0] + q1[1] * q1[1]) - (q2[0] * q2[0] + q2[1] * q2[1])));
        for(int[] point : points) {
            queue.offer(point);
        }
        int[][] ans = new int[K][2];
        for(int i = 0; i < K; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

}
