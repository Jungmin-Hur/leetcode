package flip;

import common.Flip;

@Flip
public class SearchInRotatedSortedArray {
    public static void main(String args[]) {
        System.out.println(search(new int[]{1,3}, 3));
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi) {

            int mid = (lo+hi)/2;

            if(nums[mid] == target) return mid;

            //첫값보다 중간값이 크거나 같은 경우. 로테이트가 아직 안된 경우임 0123456 (0<=3)
            if(nums[lo] <= nums[mid]){
                //찾고자 하는 값이 처음값보다 크고, 중간값보다 작으면 hi를 중간-1로 줄이고 반대면 lo를 중간+1로 잡는다.
                if(target >= nums[lo] && target < nums[mid]) { // add && target < nums[mid] 찾고자 하는 값이
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
                //첫값보다 중간값이 작은 경우, 로테이트가 된 경우임 7801234 (5601234 5>1)
            } else {
                //찾고자 하는 값이 중간값보다 크고, hi보다 작은 경우는 lo를 mid+1로 바꾼다.
                if(target > nums[mid] && target <= nums[hi]) { //target > nums[lo] -> target > nums[mid] && target <= nums[hi]
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }

        return nums[lo] == target ? lo : -1;
    }
}
