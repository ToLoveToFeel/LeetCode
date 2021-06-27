package _0909_Snakes_and_Ladders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2021/6/27 15:08
 * 执行用时：7 ms, 在所有 Java 提交中击败了66.90%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了82.39%的用户
 */
public class Solution {

    static class MyPair {
        int x, y;

        public MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] id;  // 坐标->编号
    MyPair[] cor;  // 编号->坐标

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        id = new int[n][n];
        cor = new MyPair[n * n + 1];
        for (int i = n - 1, k = 1, s = 0; i >= 0; i--, s++) {
            if (s % 2 == 0) {  // 从左到右编号
                for (int j = 0; j < n; j++, k++) {
                    id[i][j] = k;
                    cor[k] = new MyPair(i, j);
                }
            } else {
                for (int j = n - 1; j >= 0; j--, k++) {
                    id[i][j] = k;
                    cor[k] = new MyPair(i, j);
                }
            }
        }

        Queue<MyPair> q = new LinkedList<MyPair>();
        int[][] dist = new int[n][n];  // 步数
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], (int) 1e9);
        dist[n - 1][0] = 0;
        q.add(new MyPair(n - 1, 0));
        while (!q.isEmpty()) {
            MyPair t = q.remove();

            int k = id[t.x][t.y];
            if (k == n * n) return dist[t.x][t.y];
            for (int i = k + 1; i <= k + 6 && i <= n * n; i++) {
                int x = cor[i].x, y = cor[i].y;
                if (board[x][y] != -1) {  // 每个回合只能传送一次
                    int r = board[x][y];
                    x = cor[r].x;
                    y = cor[r].y;
                }
                if (dist[x][y] > dist[t.x][t.y] + 1) {
                    dist[x][y] = dist[t.x][t.y] + 1;
                    q.add(new MyPair(x, y));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println((new Solution()).snakesAndLadders(board));  // 4
    }
}
