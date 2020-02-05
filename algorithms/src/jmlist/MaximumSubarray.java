/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 */
package jmlist;

import common.Jmlist;

@Jmlist
public class MaximumSubarray {
    public static void main(String args[]) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); //6
    }

    /**
     *    -2  1 -3  4 -1  2  1 -5  4
     * -2  X -1 -4  0 -1  1  2 -3  1
     *  1     X
     * -3       x
     *  4          x
     * -1
     *  2
     *  1
     * -5
     *  4
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<nums.length; i++) {
            /**
             * 기존에 더해왔던 최대값과 현재값과 비교했을 때,
             * 만약 현재값이 누적값보다 더 크다면, 누적값은 더이상 쓸모가 없다.
             */
            currSum = Math.max(nums[i], currSum+nums[i]); //기존에 더했던 것과 지금하고 비교했을 때
            max = Math.max(max, currSum);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
