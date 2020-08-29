package _0037_Sudoku_Solver;

/**
 * Date: 2020/8/29 21:14
 * Content:
 */
class Solution {
    private boolean isValid(char[][] board, int i, int j, int num) {
        // 行有相同的,说明尝试错误.
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == num)
                return false;
        }
        // 列有相同的,说明尝试错误.
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == num)
                return false;
        }
        // 检查九宫格
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (board[row][col] == num)
                    return false;
            }
        }
        return true;
    }
    // 回溯法
    private boolean searchRes(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.')
                    continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (!isValid(board, i, j, num))
                        continue;
                    board[i][j] = num;
                    if (searchRes(board))
                        return true;
                    else
                        board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        searchRes(board);
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
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
