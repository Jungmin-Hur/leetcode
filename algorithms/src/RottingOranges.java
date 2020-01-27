import java.util.*;

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

    public static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) {
        System.out.println(orangesRotting(new int[][]{{2,2,1,0,1,1}}));

//        System.out.println(orangesRotting(new int[][]{{1},{1},{1},{1}}));
//        System.out.println(orangesRotting(new int[][]{{0,2}}));
//        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

    /**
     * 1.simulation하는 방법. 1번 status가 변경될 때마다 모든 배열을 탐색
     * 2.0,0부터 rotten 까지의 거리를 탐색 (만약에 rotten을 찾았다면 탐색을 종료) - bfs여야 최소거리를 구할 수 있음
     * 3.rotten부터 모든 것을 탐색할 때까지 검색 (만약에 rotten을 또 만나면 탐색 종료하고 다음 rotten으로)
     */
    public static int orangesRotting(int[][] grid) {
        int oneCount = 0; //만약에 바꿀 것이 없다면 0으로 리턴하기 위함
        int twoCount = 0; //만약에 rotten orange가 없다면 -1로 리턴하기 위함
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) twoCount++;
                else if (grid[i][j] == 1) oneCount++;

                if(twoCount > 0 && oneCount > 0) break;

            }
            if(twoCount > 0 && oneCount > 0) break;
        }
        if(oneCount == 0) return 0;
        if(twoCount == 0) return -1;

        int maxStep = -1;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int step = bfs(new int[]{i, j}, grid);
                    if(step == -1) return -1;
//                    System.out.println(step);
                    if(step > 0) {
                        maxStep = Math.max(maxStep, step);
                    }
                }
            }
        }
        return maxStep;
    }

    //TODO visited 에 contains 처리가 안되고 있음 why??
    public static int bfs(int[] root, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Map<Node, Integer> visited = new HashMap<>();
        int step = -1;

        //initialize...
        queue.add(root);
        visited.put(new Node(root[0], root[1]), 1);

        while(!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.peek(); //단순참조

                int currx = curr[0];
                int curry = curr[1];
                if(grid[currx][curry] == 2){//is rotten orange?
                    return step;
                }

                Node left = new Node(currx, curry-1);
                Node right = new Node(currx, curry+1);
                Node up = new Node(currx-1, curry);
                Node down = new Node(currx+1, curry);

//                int[] left = new int[]{currx, curry-1};
//                int[] right = new int[]{currx, curry+1};
//                int[] up = new int[]{currx-1, curry};
//                int[] down = new int[]{currx+1, curry};

                if(curry >= 1 && !visited.containsKey(left) && grid[currx][curry-1] != 0) {
                    queue.add(new int[]{currx, curry-1});
                    visited.put(left,1);
                }
                if(curry <= grid[0].length-2 && !visited.containsKey(right) && grid[currx][curry+1] != 0) {
                    queue.add(new int[]{currx, curry+1});
                    visited.put(right,1);
                }
                if(currx >= 1 && !visited.containsKey(up) && grid[currx-1][curry] != 0) {
                    queue.add(new int[]{currx-1, curry});
                    visited.put(up,1);
                }
                if(currx <= grid.length-2 && !visited.containsKey(down) && grid[currx+1][curry] != 0) {
                    queue.add(new int[]{currx+1, curry});
                    visited.put(down,1);
                }
                queue.poll(); //실제 지워 줌
            }
        }
        return -1;
    }

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
