//package test;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class MaxiumProduct {
//    public static void main(String args[]) {
//        System.out.println(maximumProduct(new Integer[]{1,2,3,4}));;
//        System.out.println(maximumProduct(new Integer[]{1,-2,-3,-4}));;
//    }
//
//    public static int maximumProduct(int[] nums) {
//        Arrays.sort(nums, (n1, n2) -> {
//            int a1 = (int) n1;
//            int a2 = (int) n2;
//            if(a1  < 0) {
//                a1 = n1 * -1;
//            }
//            if(a2 < 0) {
//                a2 = n2 * -1;
//            }
//            return a1 - a2;
//        });
//
////        Arrays.sort(nums, new Comparator<Integer>(){
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return 0;
////            }
////        });
//        int n1 = nums.length-1 >= 0 ? nums[nums.length-1] : 1;
//        int n2 = nums.length-2 >= 0 ? nums[nums.length-2] : 1;
//        int n3 = nums.length-3 >= 0 ? nums[nums.length-3] : 1;
//
//        System.out.println(n1 + "," + n2 + "," + n3);
//        return n1 * n2 * n3;
//    }
//
//}