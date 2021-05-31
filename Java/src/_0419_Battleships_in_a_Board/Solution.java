package _0419_Battleships_in_a_Board;

/**
 * Date: 2021/5/31 21:34
 * 执行用时：1 ms, 在所有 Java 提交中击败了98.85%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了46.14%的用户
 */
public class Solution {

    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                if (board[i][j] == 'X') res++;
            }
        return res;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
        };
        System.out.println((new Solution()).countBattleships(board));  // 2
    }
}
