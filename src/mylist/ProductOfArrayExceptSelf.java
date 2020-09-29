/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 */
package mylist;

import common.My;

@My
public class ProductOfArrayExceptSelf {
    public static void main(String args[]) {
        int[] ret = productExceptSelf(new int[]{1,2,3,4});
        for(int i : ret) {
            System.out.print(i +",");
        }
    }

    /**
     * 1 2 3 4 5
     *           index
     * 1 2 3 4 5 x
     *   2 3 4 5 0
     * 1   3 4 5 1
     * 1 2   4 5 2
     * 1 2 3   5 3
     * 1 2 3 4   4
     * 1 2 3 4 5 x
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                left[i] = 1;
            }
            else {
                left[i] = left[i-1] * nums[i-1];
            }
        }

        right[nums.length-1] = 1;
        for(int i=nums.length-1; i>=0; i--) {
            if(i==nums.length-1) {
                right[i] = 1;
            }
            else {
                right[i] = right[i+1] * nums[i+1];
            }
        }

        int[] retVal = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            retVal[i] = left[i] * right[i];
        }
        return retVal;
    }
}
