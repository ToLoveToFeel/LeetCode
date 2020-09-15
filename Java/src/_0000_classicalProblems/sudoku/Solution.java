package _0000_classicalProblems.sudoku;

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
            for (int j = 0; j < board[0].length; j++) {  // 遍历所有的格子
                if (board[i][j] != '.')  // 如果格子里面是数字，继续看下一个格子
                    continue;
                for (char num = '1'; num <= '9'; num++) {  // 格子中不是数字，尝试'1'~'9'
                    if (!isValid(board, i, j, num))  // 如果不合法，继续尝试下一个数字
                        continue;
                    board[i][j] = num;  // 合法，填入该数字
                    if (searchRes(board))  // 继续尝试
                        return true;
                    else
                        board[i][j] = '.';  // 回溯，如果不这样做的话，后面递归的数据会影响前面递归的合法性判断
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
