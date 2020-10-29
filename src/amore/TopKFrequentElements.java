/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
package amore;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> dic = new HashMap<>();
        for(int num : nums) {
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }

        //queue[0] :key, queue[1] : numbers of key
        PriorityQueue<int[]> queue = new PriorityQueue<>((q1, q2)->q2[1]-q1[1]);
        for(int n : dic.keySet()) {
            queue.offer(new int[]{n, dic.get(n)});
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++) {
            res.add(queue.poll()[0]);
        }
        return res;
    }
}
