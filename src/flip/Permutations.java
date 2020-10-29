/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 */
package flip;

import common.Flip;

import java.util.ArrayList;
import java.util.List;

@Flip
public class Permutations {
    public static void main(String args[]) {
        List<List<Integer>> res = permute(new int[]{1,2,3});
        for(int i=0; i<res.size(); i++) {
            for(int j=0; j<res.get(0).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, 0, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    public static void backtracking(int[] nums, int index, boolean[] visited, List<Integer> visitedList, List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList<>(visitedList));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i] == false) {

                visited[i] = true;
                visitedList.add(nums[i]);

                backtracking(nums, index + 1, visited, visitedList, res);

                visited[i] = false;
                visitedList.remove(visitedList.size() - 1);
            }
        }
    }
}
