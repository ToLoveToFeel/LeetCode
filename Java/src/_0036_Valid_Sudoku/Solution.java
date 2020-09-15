package _0036_Valid_Sudoku;

import java.util.HashSet;

/**
 * Date: 2020/9/15 17:14
 * Content:
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hashSet = new HashSet<>();
        // 判断行
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!hashSet.contains(c))
                        hashSet.add(c);
                    else
                        return false;
                }
            }
            hashSet.clear();
        }
        // 判断列
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!hashSet.contains(c))
                        hashSet.add(c);
                    else
                        return false;
                }
            }
            hashSet.clear();
        }
        // 判断九宫格
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int indexI = i / 3 * 3 + j;
                    int indexJ = (i % 3) * 3 + k;
                    char c = board[indexI][indexJ];
                    if (c != '.') {
                        if (!hashSet.contains(c))
                            hashSet.add(c);
                        else
                            return false;
                    }
                }
            }
            hashSet.clear();
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        char[][] board = {
                {'.', '9', '.', '.', '4', '.', '.', '.', '.'},
                {'1', '.', '.', '.', '.', '.', '6', '.', '.'},
                {'.', '.', '3', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '5', '.', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '4', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '7', '.', '.', '.', '.'}
        };
        System.out.println((new Solution()).isValidSudoku(board));
    }
}
