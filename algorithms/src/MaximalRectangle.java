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
     *
     *   0 1 1 0 1 --> 0 1 1 0 1
     *   1 2 0 1 0 --> 1 2 0 1 0
     *   0 3 1 2 0 --> 0 3 1 2 0
     *   1 4 2 3 0 --> 1 6(뒤를 읽음, 4,2,3이니까... 1*4, 2*2, 3*2 중 가장 큰 값으로 세팅) 4(1*2, 2*2중 큰 값) 3 0
     *   2 5 3 4 1 --> 8 (1*2, 2*2, 3*2 4*2 중 하나 또는 5*1 중 큰 값) 9 (1*5, 2*3, 3*3, 4*1 중 큰 값) ...
     *   해서 9가 답임
     */

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int column = matrix[0].length;
        //i, j에서 시작하는... 최대값을 저장하는 배열 선언
        int[] height = new int [column];

        int max = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++) {
                int val = matrix[i][j] - '0';
                if(val == 0) {
                    height[j] = 0;
                } else {
                    height[j] = height[j] + val;
                }
            }
            for(int j=0; j<column; j++) {
                if(height[j]==0) continue; //0인 경우 아래는 아예 연산하지 않아도 됨

                int min_height = Integer.MAX_VALUE;
                int index = 1;

                for(int k=j; k<column; k++) {
                    if(height[k]==0) break; //중간에 0을 만날 경우 더이상 계산하지 않아도 됨
                    min_height = Math.min(min_height, height[k]);
                    max = Math.max(max, min_height * index);
                    index++;
                }
            }
        }

        return max;
    }
}
