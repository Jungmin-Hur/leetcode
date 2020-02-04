package acomp_mock;

public class GenerateMatrix {
    public static void main(String args[]) {
        int n=3;
        int[][] ret = generateMatrix(n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) System.out.print(ret[i][j] +" ");
            System.out.println("");
        }
    }

    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int num = 1;
        int last = n*n;

        int rightRow = 0; // move left to right row (fix)
        int rightStartColumn = 0 ; // move left to right start column
        int downStartRow = 1; // move up to down start column
        int downColumn = n-1; // move up to down column (fix)
        int leftRow = n-1; // move left to right row (fix)
        int leftStartColumn = n-1; // move left to right start column
        int upStartRow = n-2; // move down to up start row
        int upColumn = 0; // move down to up column (fix)

        while(num <= last) {
            for(int i=rightStartColumn; i<downColumn+1 && num <= last; i++)
                matrix[rightRow][i] = num++;
            for(int i=downStartRow; i<leftRow && num <= last; i++)
                matrix[i][downColumn] = num++;
            for(int i=leftStartColumn; i>=upColumn && num <= last; i--)
                matrix[leftRow][i] = num++;
            for(int i=upStartRow; i>rightRow && num <= last; i--)
                matrix[i][upColumn] = num++;

            rightRow ++;
            rightStartColumn ++;
            downStartRow++;
            downColumn--;
            leftStartColumn--;
            leftRow--;
            upStartRow--;
            upColumn++;
        }
        return matrix;
    }
}
