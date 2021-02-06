package _0289_Game_of_Life;

import _0000_study._common.Output;

/**
 * Date: 2021/2/6 10:17
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了28.01%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了51.83%的用户
 */
public class Solution {

    public void gameOfLife(int[][] board) {

        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int live = 0;
                for (int x = Math.max(0, i - 1); x <= Math.min(n - 1, i + 1); x++)
                    for (int y = Math.max(0, j - 1); y <= Math.min(m - 1, j + 1); y++)
                        if ((x != i || y != j) && (board[x][y] & 1) == 1)
                            live++;
                int cur = board[i][j] & 1, next;
                if (cur == 1) {
                    if (live < 2 || live > 3) next = 0;
                    else next = 1;
                } else {
                    if (live == 3) next = 1;
                    else next = 0;
                }
                board[i][j] |= (next << 1);
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] >>= 1;
    }

    public static void main(String[] args) {

        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        (new Solution()).gameOfLife(board);
        Output.OutputBasicArray2D(board);
    }
}
