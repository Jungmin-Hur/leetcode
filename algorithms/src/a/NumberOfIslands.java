package a;

import common.A;
import common.My;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
@A
@My
public class NumberOfIslands {
    public static void main(String args[]) {
//        System.out.println(numIslands(new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        }));

        System.out.println(numIslands(new char[][] {
            {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
            {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
            {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
            {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
            {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}}));
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    //bfs
    public static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
//        Set<int[]> visited = new HashSet<>();

        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0, 1}, {0, -1}};
        queue.offer(new int[]{i, j});
//        visited.add(curr);
        grid[i][j] = '0';

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int[] dir : dirs) {
                int x = now[0] + dir[0];
                int y = now[1] + dir[1];

                if(x > grid.length - 1 || x < 0
                        || y > grid[0].length - 1 || y < 0) continue;

                if(grid[x][y] == '1') {
//                if(!visited.contains(curr) && grid[x][y] == '1') {
                    queue.offer(new int[]{x, y});
//                    visited.add(curr);
                    grid[x][y] = '0';
                }
            }
        }
    }

    //bfs
    public static void bfs2(char[][] grid, int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            if(now[0] < grid.length - 1 && grid[now[0]+1][now[1]] == '1') { //up
                queue.offer(new int[]{now[0]+1, now[1]});
                grid[now[0]+1][now[1]] = '0';
            }
            if(now[0] > 0 && grid[now[0]-1][now[1]] == '1') { //down
                queue.offer(new int[]{now[0]-1, now[1]});
                grid[now[0]-1][now[1]] = '0';
            }
            if(now[1] < grid[0].length - 1 && grid[now[0]][now[1]+1] == '1') { //right
                queue.offer(new int[]{now[0], now[1]+1});
                grid[now[0]][now[1]+1] = '0';
            }
            if(now[1] > 0 && grid[now[0]][now[1]-1] == '1') {//left
                queue.offer(new int[]{now[0], now[1]-1});
                grid[now[0]][now[1]-1] = '0';
            }
        }
    }

    public static int numIslands2(char[][] grid) {

        int total = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    total ++;
                    dfs(grid, i, j);
                }
            }
        }
        return total;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if(i > grid.length-1 || i < 0 ||
                j > grid[i].length-1 || j < 0 ||
                grid[i][j] == '0') return; //만약에 0인 곳을 만나면 더이상 검색하지 않고 return

        grid[i][j] = '0'; //검색한 곳은 0으로 만들어준다.
        dfs(grid, i-1, j); //왼쪽
        dfs(grid, i+1, j); //오른쪽
        dfs(grid, i, j-1); //아래
        dfs(grid, i, j+1); //위
    }

}
