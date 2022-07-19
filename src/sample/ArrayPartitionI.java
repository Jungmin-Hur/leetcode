package sample; /**
 * 561. Array Partition I
 * https://leetcode.com/problems/array-partition-i/
 */

import common.Sample;

import java.util.Arrays;

@Sample
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            if(i % 2 == 0)
                result = result + nums[i];
        }
        return result;
    }
}

// test
