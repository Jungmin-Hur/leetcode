/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class UpdateMatrix {

    public static void main(String args[]) {
        int[][] ret = updateMatrix(new int[][] {{0,0,0}, {0,1,0}, {1,1,1}});
        for(int i = 0; i < ret.length; i++) {
            for(int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1){
                    matrix[i][j] = bfs(new int[]{i, j}, matrix);
                }
            }
        }
        return matrix;
    }

    public static int bfs(int[] root, int[][] matrix) {

        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();

        queue.add(root);
        visited.add(root);

        int step = 0;

        while(!queue.isEmpty()) {

            step++;

            for (int i = 0; i < queue.size(); ++i) {

                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                if (matrix[x][y] == 0) { // find 0!!!
                    return step;
                }

                int[] left = new int[]{x, y - 1};
                int[] right = new int[]{x, y + 1};
                int[] up = new int[]{x - 1, y};
                int[] down = new int[]{x + 1, y};

                if (!visited.contains(left) && y >= 1) {
                    queue.offer(left);
                    visited.add(left);
                }
                if (!visited.contains(right) && y <= matrix[0].length - 2) {
                    queue.offer(right);
                    visited.add(right);
                }
                if (!visited.contains(up) && x >= 1) {
                    queue.offer(up);
                    visited.add(up);
                }
                if (!visited.contains(down) && x <= matrix.length - 2) {
                    queue.offer(down);
                    visited.add(down);
                }
            }
        }

        return -1;
    }
}
