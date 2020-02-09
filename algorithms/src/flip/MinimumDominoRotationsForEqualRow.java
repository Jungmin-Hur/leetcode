/**
 * 1007. Minimum Domino Rotations For Equal Row
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
package flip;

import common.Flip;

@Flip
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int totalLength = A.length;
        int result = Integer.MAX_VALUE;

        int[] basises = {A[0], B[0]};

        for(int basis : basises) {
            int aCount = 0, bCount = 0;
            for(int i = 0; i < totalLength; i++) {
                if(aCount < Integer.MAX_VALUE && A[i] != basis) { //A체크
                    if(B[i] == basis) aCount++; //B로 교체가 가능?
                    else aCount = Integer.MAX_VALUE; //만들 수 없음
                }
                if(bCount < Integer.MAX_VALUE && B[i] != basis) { //B체크
                    if(A[i] == basis) bCount++; //A로 교체가 가능?
                    else bCount = Integer.MAX_VALUE; //만들 수 없음
                }
                if(aCount == Integer.MAX_VALUE && bCount == Integer.MAX_VALUE)
                    break; //못 만듬 확정!! for를 나갑시다.
            }
            result = Math.min(result,Math.min(aCount, bCount));
        }

        return result==Integer.MAX_VALUE ? -1 : result;
    }
}
