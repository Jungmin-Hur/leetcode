package sample; /**
 * 1122. Relative Sort Array
 * https://leetcode.com/problems/relative-sort-array/
 */

import common.Sample;

import java.util.*;

@Sample
public class RelativeSortArray {

    public static void main(String args[]) {
        int[] ret = relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
        for(int n : ret) {
            System.out.print(n + " ");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> dic1 = new HashMap<>();
        Set<Integer> dic2 = new HashSet<>();
        for(int n: arr2) {
            dic2.add(n);
        }

        int[] notFound = new int[arr1.length];
        int notFoundIndex = 0;
        for(int n : arr1) {
            dic1.put(n, dic1.getOrDefault(n, 0) + 1);

            if(!dic2.contains(n)) {
                notFound[notFoundIndex++] = n;
            }
        }

        int[] ret = new int[arr1.length];
        int retIndex = 0;
        for(int n : arr2) {
            int count = dic1.get(n);
            for(int i=0; i<count; i++) {
                ret[retIndex++] = n;
            }
        }

//        for(int n : notFound) {
//            System.out.print(n + ",");
//        }
//        System.out.println("--1");
        Arrays.sort(notFound,0,notFoundIndex);
//        for(int n : notFound) {
//            System.out.print(n + ",");
//        }
//        System.out.println("--2");

        int j = 0;
        for(int i=0; i<notFoundIndex; i++) {
            ret[retIndex++] = notFound[i];
        }

        return ret;
    }
}
