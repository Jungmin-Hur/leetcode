package arraystringandhash;

import common.Acomp;
import common.Flip;
import common.FlippedSchoolType;

@Acomp
@Flip(value= FlippedSchoolType.ARRAY_STRING_AND_HASH)
public class TrappingRainWater {
    public static void main(String args[]) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    /**
     * 2 pointer
     * 좌우에서 한꺼번에 접근
     * 왼쪽과 오른쪽 중 더 작은 높이를 가진 것을 기준으로 선택한다.
     * 왼쪽이 기준일 때 : 왼쪽에서 접근시... 우측에 현재 기준보다 높은 점까지 모두 채울 수 있다.
     * 오른쪽이 기준일 때 : 오른쪽에서 접근시.. 좌측에 현재 기준보다 높은 점까지 모두 채울 수 있다.
     * 이게 가능 한 이유는 높은 것을 기준으로 하면 채울수가 없거나 덜 채워지는데 낮을 것을 기준으로 했기 때문에..
     */
    public static int trap(int[] height) {
        if(height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;

        int total = 0;
        boolean leftTurn = height[left] <= height[right] ? true : false;

        while(left < right) {
            boolean isFinish = true;

            //left가 기준일 때
            if(leftTurn == true) {
                for(int i=left;i<right;i++) {
                    if(height[i] > height[left]) {
                        left = i; //left가 바뀜
                        isFinish = false;
                        break;
                    } else {
                        total = total + (height[left]-height[i]);//물채우기
                    }
                }
            //right가 기준일 때
            } else {
                for(int i=right;i>left;i--) {
                    if(height[i] > height[right]) {
                        right = i; //right 바뀜
                        isFinish = false;
                        break;
                    } else {
                        total = total + (height[right]-height[i]);//물채우기
                    }
                }
            }
            if(isFinish==true) break;
            leftTurn = height[left] <= height[right] ? true : false;
        }

        return total;
    }
}
