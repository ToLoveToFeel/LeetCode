package _0037_Sudoku_Solver;

import _0000_study._common.Output;

import java.util.Arrays;

/**
 * Date: 2020/8/29 21:14
 * Content:
 */
class Solution {

//    private boolean isValid(char[][] board, int i, int j, int num) {
//
//        // 行有相同的,说明尝试错误.
//        for (int row = 0; row < 9; row++)
//            if (board[row][j] == num)
//                return false;
//        // 列有相同的,说明尝试错误.
//        for (int col = 0; col < 9; col++)
//            if (board[i][col] == num)
//                return false;
//        // 检查九宫格
//        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++)
//            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++)
//                if (board[row][col] == num)
//                    return false;
//        return true;
//    }
//
//    // 回溯法
//    private boolean searchRes(char[][] board) {
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] != '.') continue;
//
//                for (char num = '1'; num <= '9'; num++) {
//                    if (!isValid(board, i, j, num)) continue;
//
//                    board[i][j] = num;
//                    if (searchRes(board)) return true;
//                    else board[i][j] = '.';
//                }
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void solveSudoku(char[][] board) {
//
//        if (board == null || board.length == 0) return;
//        searchRes(board);
//    }
boolean[][] row = new boolean[9][9], col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Arrays.fill(row[i], false);
            Arrays.fill(col[i], false);
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                Arrays.fill(cell[i][j], false);

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                }
        dfs(board, 0, 0);
    }

    // 从(0, 0)开始搜
    private boolean dfs(char[][] board, int x, int y) {

        if (y == 9) {
            x++; y = 0;
        }
        if (x == 9) return true;

        if (board[x][y] != '.') dfs(board, x, y + 1);
        for (int i = 0; i < 9; i++) {
            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                board[x][y] = (char) ('1' + i);
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                if (dfs(board, x, y + 1)) return true;
                board[x][y] = '.';
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        (new Solution()).solveSudoku(board);
        Output.OutputBasicArray2D(board);
    }
}
