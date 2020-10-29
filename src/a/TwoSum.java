/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
package a;

import common.A;

import java.util.HashMap;
import java.util.Map;

@A
public class TwoSum {
    public static void main(String args[]) {
        int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res.length);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dic = new HashMap<>();
        int index=0;
        for(int num : nums) {
            int now_target = target - num;
            if(dic.get(now_target) != null) { //found!
                return new int[]{dic.get(now_target), index};
            }
            dic.put(num, index++);
        }
        return null;
    }
}
