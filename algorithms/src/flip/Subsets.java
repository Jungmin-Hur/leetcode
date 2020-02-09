package flip; /**
 * 78. jmlist.Subsets
 * https://leetcode.com/problems/subsets/
 */

import common.Flip;
import common.My;

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
@My
@Flip
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

    //approach#2. Lexicographic (Binary Sorted) jmlist.Subsets
    //배열을 만들고, 이진수로 변환함
    //[1,2,3]이 input이라면...
    //2^3 => 총 8가지 경우의 수가 나오므로 8개의 모든 비트 조합의 데이터를 만든다.  000, 001, 010, ... 111
    //bit가 1인 경우 nums array index와 매핑시켜 리턴값을 넣는다.
    public static List<List<Integer>> bitmask_subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int startNum = (int) Math.pow(2, n);
        int endNum = (int) Math.pow(2, n+ 1);

        for (int i = startNum; i < endNum; ++i) {
            //만약 세자리라고 하면... 2^3 (8) ~ 2^4-1(15) 까지 숫자를 표현해야 함.
            //이진수로 1000 ~ 1111이 되므로, 세개의 숫자로 만들수 있는 경우의 수를 구해야 하므로, 제일 첫자리를 제거함
            String binaryNum = Integer.toBinaryString(i).substring(1);

            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j)
                if (binaryNum.charAt(j) == '1') curr.add(nums[j]);
            res.add(curr);
        }
        return res;
    }

//    //with backtracking alogrithm... refer to solution..
//    public static void backtrack(int first, ArrayList<Integer> curr, int[] nums, int n, int k) {
//
//        List<List<Integer>> output = new ArrayList();
//
//        // if the combination is done
//        if (curr.size() == k)
//            output.add(new ArrayList(curr));
//
//        for (int i = first; i < n; ++i) {
//            // add i into the current combination
//            curr.add(nums[i]);
//            // use next integers to complete the combination
//            backtrack(i + 1, curr, nums);
//            // backtrack
//            curr.remove(curr.size() - 1);
//        }
//    }
}
