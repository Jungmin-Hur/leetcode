package acomp;

import common.Acomp;
import common.Jmlist;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
@Acomp
@Jmlist
public class NumberOfIslands {
    public static void main(String args[]) {
        System.out.println(numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
    }
    public static int numIslands(char[][] grid) {

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
