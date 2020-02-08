package a;

import common.A;
import common.My;

import java.util.*;

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 */
@A
@My
public class RottingOranges {

    public static void main(String args[]) {
        System.out.println(orangesRotting(new int[][]{{1},{1},{1},{1}}));
        System.out.println(orangesRotting(new int[][]{{0,2}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,0,0},{0,1,1}})); // 4
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}})); // 4
        System.out.println(orangesRotting(new int[][]{{2,2,1,0,1,1}}));
    }

    /**
     * the value 0 representing an empty cell;
     * the value 1 representing a fresh orange;
     * the value 2 representing a rotten orange.
     */
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = -1;
        int freshCount = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i, j}); //gathering rotten oranges to queue
                else if(grid[i][j] == 1) freshCount++;
            }
        }

        if(freshCount == 0) return 0; //there is no fresh orange.
        if(queue.size() == 0) return -1; //there is noting to rotten.

        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size(); //Rotten oranges simultaneously affect adjacent fresh oranges.
            for(int i = 0; i < size; i++) {
                //if using queue.size() instead of size, it will be not working properly, beacuse queue is changeable.
                int[] now = queue.poll();
                for (int[] dir : dirs) { //find fresh oragnes from adjacent directions.
                    int x = now[0] + dir[0];
                    int y = now[1] + dir[1];

                    if (x > grid.length - 1 || x < 0 || y > grid[0].length - 1 || y < 0) continue;
                    if (grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2; //rotten..!!
                        freshCount--;
                    }
                }
            }
        }
        //if freshCount is not 0, it means that all fresh orange couldn't be rotten.
        return freshCount != 0 ? -1 : minutes;
    }

    //bfs ver2
    public static int orangesRotting2(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();

        int freshCount = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) {
                    int[] curr = new int[]{i, j};
                    queue.offer(curr);
                    visited.add(curr);
                } else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if(queue.size() == 0) {
            if(freshCount == 0) return 0;
            return -1; //there is noting to rotten.
        }
        if(freshCount == 0) return 0; //there is no fresh orange.

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int step = -1;

        while (!queue.isEmpty()) {
            step++;
            int queueSize = queue.size(); //이렇게 해야 queue를 한번에 돌릴 수 있음

            for(int i = 0; i < queueSize; i++) {
                int[] now = queue.poll();


                for (int[] dir : dirs) {
                    int x = now[0] + dir[0];
                    int y = now[1] + dir[1];
                    int[] curr = new int[]{x, y};

                    if (x > grid.length - 1 || x < 0
                            || y > grid[0].length - 1 || y < 0) continue;

                    if (!visited.contains(curr) && grid[x][y] == 1) {
                        queue.offer(curr);
                        visited.add(curr);
                        grid[x][y] = 2;
                        freshCount--;
                    }
                }
            }
        }
        return freshCount != 0 ? -1 : step;
    }

    /**
     * 1.simulation하는 방법. 1번 status가 변경될 때마다 모든 배열을 탐색
     * 2.0,0부터 rotten 까지의 거리를 탐색 (만약에 rotten을 찾았다면 탐색을 종료) - bfs여야 최소거리를 구할 수 있음
     * 3.rotten부터 모든 것을 탐색할 때까지 검색 (만약에 rotten을 또 만나면 탐색 종료하고 다음 rotten으로)
     */

//BFS template!!!
///**
// * Return the length of the shortest path between root and target node.
// */
//int BFS(Node root, Node target) {
//    Queue<Node> queue;  // store all nodes which are waiting to be processed
//    Set<Node> visited;  // store all the nodes that we've visited
//    int step = 0;       // number of steps neeeded from root to current node
//    // initialize
//    add root to queue;
//    add root to visited;
//    // BFS
//    while (queue is not empty) {
//        step = step + 1;
//        // iterate the nodes which are already in the queue
//        int size = queue.size();
//        for (int i = 0; i < size; ++i) {
//            Node cur = the first node in queue;
//            return step if cur is target;
//            for (Node next : the neighbors of cur) {
//                if (next is not in visited) {
//                    add next to queue;
//                    add next to visited;
//                }
//                remove the first node from queue;
//            }
//        }
//    }
//    return -1;          // there is no path from root to target
//}
}
