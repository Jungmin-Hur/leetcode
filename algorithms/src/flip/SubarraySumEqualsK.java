package flip;

import common.Flip;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
@Flip
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int total = nums.length;
        int count = 0;

        for(int i = 0; i < total ; i++) {
            int sum = nums[i];
            if(sum == k) count++;
            for(int j = i + 1 ; j < total ; j++) {
                sum = sum + nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }
}
