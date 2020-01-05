import java.util.HashSet;
import java.util.Set;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int totalLength = A.length;
        int result = -1;

        Set<Integer> set = new HashSet<>();
        set.add(A[0]);
        set.add(B[0]);

        for(int basis : set) {
            int aCount = 0, bCount = 0;
            for(int i = 0; i < totalLength; i++) {
                if(aCount != -1 && A[i] != basis) { //A체크
                    if(B[i] == basis) aCount++; //B로 교체가 가능?
                    else aCount = -1; //만들 수 없음
                }
                if(bCount != -1 && B[i] != basis) { //B체크
                    if(A[i] == basis) bCount++; //A로 교체가 가능?
                    else bCount = -1; //만들 수 없음
                }
                if(aCount == -1 && bCount == -1) break; //못 만듬 확정!! for를 나갑시다.
            }

            if(result == -1) { //result에 데이터가 세팅된 적이 없음
                if(aCount == -1 && bCount > -1) result = bCount; //b에서 찾음
                else if(aCount > -1 && bCount == -1) result = aCount; //a에서 찾음
                else if(aCount > -1 && bCount > -1) result = Math.min(aCount, bCount);
            } else {
                if(aCount == -1 && bCount > -1) result = Math.min(result,bCount);
                else if(aCount > -1 && bCount == -1) result = Math.min(result,aCount);
                else if(aCount > -1 && bCount > -1) result = Math.min(result,Math.min(aCount, bCount));
            }
        }

        return result;
    }
}
