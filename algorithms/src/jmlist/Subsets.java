package jmlist; /**
 * 78. jmlist.Subsets
 * https://leetcode.com/problems/subsets/
 */

import common.Jmlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
@Jmlist
public class Subsets {

    public static void main(String args[]) {
        subsets(new int[]{1,2,3});
    }
    public static List<List<Integer>> subsets(int[] nums) {
//        n = nums.length;
//        for (k = 0; k < n + 1; ++k) {
//            backtrack(0, new ArrayList<Integer>(), nums);
//        }
//        return output;

        return bitmask_subsets(nums);
    }

    static List<List<Integer>> output = new ArrayList();
    static int n, k;

    //with backtracking alogrithm... refer to solution..
    public static void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    //approach#2. Lexicographic (Binary Sorted) jmlist.Subsets
    //배열을 만들고, 이진수로 변환함
    //[1,2,3]이 input이라면...
    //2^3 => 총 8가지 경우의 수가 나오므로 8개의 모든 비트 조합의 데이터를 만든다.  000, 001, 010, ... 111
    //bit가 1인 경우 nums array index와 매핑시켜 리턴값이 넣는다.
    public static List<List<Integer>> bitmask_subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        System.out.println(Math.pow(2, n) + "," + Math.pow(2, n + 1));
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            //만약 for (int i = 1; i < (int)Math.pow(2, n); ++i)라고 했다면? 1, 10, 11 등 맨 앞자리를 0으로 채우지 못하게 된다.
            String bitmask = Integer.toBinaryString(i).substring(1); //8~16을 구해서 8개의 모든 경우의 수를 구하려고 함
            System.out.println(i + "," + Integer.toBinaryString(i) + "::" + bitmask);

            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
