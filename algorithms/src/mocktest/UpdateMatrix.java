package mocktest; /**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/
 */

import common.MockTest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

@MockTest
public class UpdateMatrix {

    //updateMatrix is mine
    //updateMatrix2 come from dicuss
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

        int step = -1;

        while(!queue.isEmpty()) {

            step++;
            int size = queue.size();
            //만약에 아래 for에서 size를 쓰지 않고 queue.size()를 썻다면, queue의 사이즈가 변하기 때문에 오류가 발생하게 됨

            for (int i = 0; i < size; ++i) {

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

                if (!visited.contains(left) && y > 0) {
                    queue.offer(left);
                    visited.add(left);
                }
                if (!visited.contains(right) && y < matrix[0].length - 1) {
                    queue.offer(right);
                    visited.add(right);
                }
                if (!visited.contains(up) && x > 0) {
                    queue.offer(up);
                    visited.add(up);
                }
                if (!visited.contains(down) && x < matrix.length - 1) {
                    queue.offer(down);
                    visited.add(down);
                }
            }
        }

        return -1;
    }

    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // Soluton: use BFS starting from each 0 cell and mark new length for each 1 cell
    // Note: Need a way to differentiate original 1 and distance 1
    public static int[][] updateMatrix2(int[][] matrix) {
        Queue<Point> queue = new LinkedList<>();
        // Fill 1 with -1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = -1;
                } else {
                    queue.offer(new Point(i, j));
                }
            }
        }
        // BFS starting from each 0 cell
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                for (int[] dir : dirs) {
                    int ii = curPoint.x + dir[0];
                    int jj = curPoint.y + dir[1];

                    if (ii >= 0 && jj >= 0 && ii < matrix.length && jj < matrix[0].length) {
                        if (matrix[ii][jj] == -1) {
                            matrix[ii][jj] = length;
                            queue.offer(new Point(ii, jj));
                        }
                    }
                }
            }
        }

        return matrix;
    }
}
