public class FindPivotIndex {
    public static void main(String args[]) {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
        System.out.println(pivotIndex(new int[]{1}));
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }

        int leftSum = 0;
        for(int i=0; i<nums.length; i++) {
            if(leftSum == (sum-leftSum-nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    //아래와 같이 접근할 경우.. 음수가 포함된 array에 대해 잘못된 계산이 됨
    public static int pivotIndex2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if(right < 0) return -1;

        int leftSum = nums[left++];
        int rightSum = nums[right--];

        while(left < right) {
            if(leftSum > rightSum) {
                rightSum += nums[right--];
            } else {
                leftSum += nums[left++];
            }
            if(leftSum==rightSum) {
                return left;
            }
        }

        return -1;
    }

}
