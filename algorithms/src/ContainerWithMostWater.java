public class ContainerWithMostWater {
    public static void main(String args[]) {
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6}));
    }

    public static int maxArea(int[] height) {
        //1,8,6,2,5,4,8,3,7
        //1,7 둘중 큰놈은 두고 작은게 움직임
        //8,7
        //8,3
        //8,8
        //6,8 같으면 앞에 있는게 움직임
        //2,8
        //5,8
        //4,8
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right-left));
            if(height[left]>height[right]) right--; //if로 한번만 체크하지 않고 여기서 부등호가 바뀔때까지 계속 가도 됨.
            else if(height[left]<=height[right]) left++;
        }
        return max;
    }
}
