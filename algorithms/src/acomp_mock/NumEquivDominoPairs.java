package acomp_mock;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 */
public class NumEquivDominoPairs {
    public static void main (String args[]) {
        System.out.println(numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}}));
//        System.out.println(numEquivDominoPairs(new int[][]{{1,2},{2,1},{3,4},{5,6}}));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> reverseMap = new HashMap<>();

        int totCount = 0;
        for(int[] domino : dominoes) {
            boolean find = false;
            int mapVal = domino[0]*10+domino[1];
            int reverseVal = domino[1]*10+domino[0];

            if(map.get(mapVal) != null) {
                int n = map.get(mapVal);
                map.put(mapVal, n+1);
                find = true;
            }
            if(reverseMap.get(reverseVal) != null) {
                find = true;
            }
            map.put(mapVal, 1);
            reverseMap.put(reverseVal, 1);

            if(find == true) totCount++;
            if(find != false) map.put(mapVal, 1);

        }
        return totCount;
    }
}
