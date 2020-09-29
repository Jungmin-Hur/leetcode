package sample; /**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */

import common.Sample;

import java.util.Arrays;

@Sample
public class SquaresOfASortedArray {
    public static void main(String args[]) {
//        int[] ret = sortedSquares(new int[]{-7,-3,2,3,11});
        int[] ret = sortedSquares(new int[]{-3,-1});
        for(int n : ret) {
            System.out.print(n + ", ");
        }
        System.out.println("");
    }

    //idea
    //음수는 제곱하면 앞에 있는 수가 더 큰수
    //양수는 제곱하면 뒤에 있는 수가 더 큰수
    public static int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] retVal = new int[N];
        int minusIndex = -1;
        int plusIndex = -1;
        int retIndex = 0;

        for(int i = 0; i< N; i++) {
            if(A[i] < 0) {
                minusIndex = i;
            }
            A[i] = A[i] * A[i];
        }
        plusIndex = minusIndex+1;

        while(minusIndex >= 0 && plusIndex < N) {
            if(A[minusIndex] > A[plusIndex]) {
                retVal[retIndex++] = A[plusIndex++];
            } else {
                retVal[retIndex++] = A[minusIndex--];
            }
        }

        for(int i=plusIndex; i<N; i++) {
            retVal[retIndex++] = A[i];
        }
        for(int i=minusIndex; i>=0; i--) {
            retVal[retIndex++] = A[i];
        }

        return retVal;
    }

    public static int[] sortedSquares2(int[] A) {
        for(int i = 0; i< A.length; i++) {
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);

        return A;
    }
}
