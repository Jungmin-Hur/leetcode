public class MaximalRectangle {
    public static void main(String args[]) {
        System.out.println(maximalRectangle(new char[][]{
            {'0','1','1','0','1'},
            {'1','1','0','1','0'},
            {'0','1','1','1','0'},
            {'1','1','1','1','0'},
            {'1','1','1','1','1'},
            {'0','0','0','0','0'}}));

    }

    /**
     * idea
     * 계산하는 row에서 height를 저장하는 배열 height를 만듬
     * 대상 row의 값이 1인 경우 height는 이전 height + 1, 그렇지 않으면 0
     * 해당 row에서 left부터 읽는다.
     * 면적 = index * height
     * 만약 i-1, j-1이 0이거나 j가 0이면 index초기화되어 1
     * 그렇지 않으면 이전 index++
     * 가장 큰 면적을 저장해 둔다.
     *
     *    1 0 1 0 0 --> 1*1 0 1*1 0 0 ==> max는 1
     * -> 2 0 2 1 1 --> 2*1 0 2*1 1*2 1*3 ==> max는 3
     * -> 3 1 3 2 2 --> 3*1 1*2 3*1(i-1, j-1이 0이거나 i-1, j가 0이면 index 초기화) 2*2, 2*3 => max=6
     * -> 4 0 0 3 0 --> 4*1 0 0 0 3*1 0 ==> max=4
     * 답은 6
     *
     * index초기화시...해당 높이기준으로
     */

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int column = matrix[0].length;
        //i, j에서 시작하는... 최대값을 저장하는 배열 선언
        int[] height = new int [column];

        int max = 0;
        for(int i=0; i<row; i++){
            int index = 0;
            for(int j=0; j<column; j++) {
                if(matrix[i][j] == '1') {
                    index ++;
                }

                if(j==0) {
                    index = 1;
                } else {
                    if(i==0) {
                        if(matrix[i][j-1] == '0') index = 1;
                    } else if(matrix[i-1][j] == '0' && matrix[i-1][j] == '0') {

                    } else if(matrix[i-1][j-1] == '0' || matrix[i][j-1] == '0') {
                        index = 1; //index초기화
                    }
                }

                if(matrix[i][j] == '1') {
                    height[j] = height[j] + 1;

                } else {
                    height[j] = 0;
                }
                max = Math.max(max, index*height[j]);
                System.out.println(i + "," + j + "," + max);
            }
        }

        return max;
    }
}
