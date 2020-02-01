/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
package acomp;

import common.Acomp;

@Acomp
public class SearchA2DMatrixII {

    public static void main(String args[]) {
        System.out.println(searchMatrix(new int[][]{{1,2,3,4,5}},4));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false; //[[]] 인 경우

        int column = matrix[0].length;

        for(int i=0; i<matrix.length; i++) {

            if(matrix[i][0] > target) break;

            int start = 0;
            int end = column-1;
            while(start <= end) {
                // 12찾기
                // start 0, end 4
                // mid 2
                // 1 4 7 11 15
                // start 2, end 4
                // mid 3
                // start 3, end 4
                // mid 3
                int mid = (start + end) / 2;
                if(matrix[i][mid] == target) return true;
                if(matrix[i][end] == target) return true;

                if(start == mid) break;
                if(matrix[i][mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        return false;
    }
}
