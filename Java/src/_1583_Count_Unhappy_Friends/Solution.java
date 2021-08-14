package _1583_Count_Unhappy_Friends;

import java.util.Arrays;

/**
 * Date: 2021/8/14 10:05
 * Content:
 */
public class Solution {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] pos = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] p = preferences[i];
            for (int j = 0; j < p.length; j++) pos[i][p[j]] = j;
        }

        int[] st = new int[n];
        Arrays.fill(st, 0);
        for (int i = 0; i < n / 2; i++)
            for (int j = 0; j < n / 2; j++)
                if (i != j) {
                    int x = pairs[i][0], y = pairs[i][1];
                    int u = pairs[j][0], v = pairs[j][1];
                    if (pos[x][u] < pos[x][y] && pos[u][x] < pos[u][v] || pos[x][v] < pos[x][y] && pos[v][x] < pos[v][u])
                        st[x] = 1;
                    if (pos[y][u] < pos[y][x] && pos[u][y] < pos[u][v] || pos[y][v] < pos[y][x] && pos[v][y] < pos[v][u])
                        st[y] = 1;
                }

        int res = 0;
        for (int i = 0; i < n; i++) res += st[i];

        return res;
    }

    public static void main(String[] args) {

        int[][] preferences = {
                {1, 2, 3},
                {3, 2, 0},
                {3, 1, 0},
                {1, 2, 0}
        };
        int[][] pairs = {
                {0, 1},
                {2, 3}
        };
        System.out.println((new Solution()).unhappyFriends(4, preferences, pairs));  // 2
    }
}
