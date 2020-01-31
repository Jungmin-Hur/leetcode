package arraystringandhash;

import common.Flip;
import common.FlippedSchoolType;

@Flip(value= FlippedSchoolType.ARRAY_STRING_AND_HASH)
public class NextPermutation {
    //풀이에 있는 답임
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //뒤에서부터 와서 내림수가 생기는 지점을 구함
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //내림수가 생긴 지점의 값보다 큰 가장 마지막자리 수를 구함
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            //위에서 구한 두 지점을 바꿈
            swap(nums, i, j);
        }
        //내림수가 생기는 구간 이후 구간을 모두 반대로 만듬
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
