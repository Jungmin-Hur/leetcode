/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 */
package amore;

import common.A;

@A
public class WordSearch {
    static private char[][] board;
    static private int ROWS;
    static private int COLS;

    public static void main(String args[]) {
        System.out.println(exist(new char[][]{
                {'A'},
                {'B'}}, "BA")); //true
        System.out.println(exist(new char[][]{
                {'A'},
                {'A'}}, "AAA")); //false
        System.out.println(exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}}, "ABCCS")); //true
        System.out.println(exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}}, "ABCCK")); //false
    }

    public static boolean exist(char[][] board, String word) {
        for(int i=0; i< board.length; i++) {
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != word.charAt(0)) continue;
                if(backtracking(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }

    public static boolean backtracking(int i, int j, int pos, char[][] board, String word) {

        if(pos >= word.length()) return true;

        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return false;

        if(word.charAt(pos) != board[i][j]) return false;

        //dfs
        char temp = board[i][j];
        board[i][j] = ' '; // not for search, this is like visited = true;
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int d = 0; d < 4; d++) {
            if(backtracking(i + dir[d][0], j + dir[d][1], pos + 1, board, word)) return true;
        }
        board[i][j] =  temp; //recover data.. this is like visited = false;

        return false;
    }
}
