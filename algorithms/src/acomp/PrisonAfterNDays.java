package acomp; /**
 * 957. Prison Cells After N Days
 * https://leetcode.com/problems/prison-cells-after-n-days/
 */

import common.Acomp;
import common.Jmlist;

@Acomp
@Jmlist
public class PrisonAfterNDays {
    public static void main(String args[]) {
//        int[] result = prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 1000);
//        int[] result = prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 15);
//        int[] result = prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000);
//        int[] result = prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000);

        int[] result = prisonAfterNDays(new int[]{1,0,0,1,0,0,0,1}, 826);

        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println("");
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] temp = new int[cells.length];

        if(N%14==0) N=14;
        else N=N%14;

        for(int i=0; i<N; i++) {
            for(int j=1; j<cells.length-1; j++) {
                if(cells[j-1]==0&&cells[j+1]==0) temp[j] = 1;
                else if(cells[j-1]==1&&cells[j+1]==1) temp[j] = 1;
                else temp[j] = 0;
            }
            temp[0] = 0;
            temp[cells.length-1] = 0;

            for(int k=0; k<cells.length; k++) {
                cells[k] = temp[k];
            }
        }

        return cells;
    }
}
