package _0000_study.classicalproblems.wordsearch;

/**
 * Date: 2020/9/3 16:10
 * Content:
 * 典型的二维平面回溯问题
 */
public class Solution {
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 四个方向：上右下左
    int m, n;  // board的行数和列数
    boolean[][] visited;  // 记录某个位置是否访问过，访问过为true

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // 从board[startx][starty]开始，向四个方向寻找
    private boolean searchBoard(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() - 1)
            return board[startx][starty] == word.charAt(index);

        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            // 从startx,starty出发，向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] &&
                        searchBoard(board, word, index + 1, newx, newy))
                    return true;
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (board.length == 0)
            throw new IllegalArgumentException("列数为0!");
        n = board[0].length;
        visited = new boolean[m][n];  // 默认为false

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (searchBoard(board, word, 0, i, j))
                    return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        Solution solution = new Solution();
        System.out.println(solution.exist(board, "ABCCED"));
        System.out.println(solution.exist(board, "SEE"));
        System.out.println(solution.exist(board, "ABCB"));
    }
}
