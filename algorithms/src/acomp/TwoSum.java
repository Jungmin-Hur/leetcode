/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
package acomp;

import common.Acomp;

import java.util.HashMap;
import java.util.Map;

@Acomp
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
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
