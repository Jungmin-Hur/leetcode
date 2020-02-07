/**
 * 346. Moving Average from Data Stream
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */
package amock;

import common.A;
import common.Sample;

import java.util.LinkedList;
import java.util.Queue;

@A
@Sample
public class MovingAverage {
    private int size;
    private int total = 0;
    private Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(queue.size() >= this.size) {
            int remove = queue.poll();
            queue.offer(val);
            total = total - remove;
            total = total + val;
        } else {
            total = total + val;
            queue.offer(val);
        }

        return (double) total / queue.size();
    }
}


