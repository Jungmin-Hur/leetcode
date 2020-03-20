package flip;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((q1, q2) -> q2 - q1);
        for(int num : nums) {
            queue.offer(num);
        }

        int i = 0;
        int val = 0;
        while(i < k) {
            val = queue.poll();
            i++;
        }
        return val;
    }
}
