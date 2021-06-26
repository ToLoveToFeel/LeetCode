package _0773_Sliding_Puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 时间复杂度：O(n!)
    private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 某个点的四个方向，上右下左

    public int slidingPuzzle(int[][] board) {

        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> dist = new HashMap<>();  // 记录到达 String 需要的步骤，不存在在visited里代表没访问到

        String start = boardToString(board);
        if (start.equals("123450")) return 0;

        q.add(start);
        dist.put(start, 0);
        while (!q.isEmpty()) {
            String t = q.remove();

            ArrayList<String> nexts = getNexts(t);

            for (String next : nexts)
                if (!dist.containsKey(next)) {
                    q.add(next);
                    dist.put(next, dist.get(t) + 1);
                    if (next.equals("123450")) return dist.get(next);
                }
        }
        return -1;
    }

    private ArrayList<String> getNexts(String s) {

        ArrayList<String> res = new ArrayList<>();
        int[][] cur = stringToBoard(s);
        int zero;
        for (zero = 0; zero < 6; zero++)
            if (0 == cur[zero / 3][zero % 3])
                break;

        int x = zero / 3, y = zero % 3;
        for (int d = 0; d < 4; d++) {
            int a = x + dirs[d][0], b = y + dirs[d][1];
            if (a >= 0 && a < 2 && b >= 0 && b < 3) {
                swap(cur, x, y, a, b);
                res.add(boardToString(cur));
                swap(cur, x, y, a, b);
            }
        }
        return res;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                sb.append(board[i][j]);
        return sb.toString();
    }

    private int[][] stringToBoard(String s) {

        int[][] res = new int[2][3];
        for (int i = 0; i < s.length(); i++) res[i / 3][i % 3] = s.charAt(i) - '0';
        return res;
    }

    private void swap(int[][] board, int x, int y, int newX, int newY) {
        int t = board[x][y];
        board[x][y] = board[newX][newY];
        board[newX][newY] = t;
    }

    public static void main(String[] args) {

        int[][] board = {{4, 1, 2}, {5, 0, 3}};
        System.out.println((new Solution()).slidingPuzzle(board));  // 5
    }
}
