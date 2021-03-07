package _0675_Cut_Off_Trees_for_Golf_Event;

import _0000_study._common.Build;

import java.util.*;

/**
 * Created by WXX on 2021/3/7 18:51
 * 执行用时：242 ms, 在所有 Java 提交中击败了96.69%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了87.60%的用户
 */
public class Solution {

    static class Tree implements Comparable<Tree> {
        int x, y, h;

        public Tree(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override
        public int compareTo(Tree o) {
            return this.h - o.h;
        }
    }

    int n, m;
    int[][] g;

    private int bfs(Tree st, Tree ed) {
        if (st.x == ed.x && st.y == ed.y) return 0;
        Queue<Tree> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], 0x3f3f3f3f);
        dist[st.x][st.y] = 0;
        q.add(st);
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Tree t = q.remove();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] != 0) {
                    if (dist[x][y] > dist[t.x][t.y] + 1) {
                        dist[x][y] = dist[t.x][t.y] + 1;
                        if (x == ed.x && y == ed.y) return dist[x][y];
                        q.add(new Tree(x, y, -1));
                    }
                }
            }
        }
        return -1;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        n = forest.size();
        m = forest.get(0).size();
        g = new int[n][m];
        List<Tree> trs = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                g[i][j] = forest.get(i).get(j);
                if (g[i][j] > 1) trs.add(new Tree(i, j, g[i][j]));
            }
        Collections.sort(trs);
        Tree last = new Tree(0, 0, -1);
        int res = 0;
        for (Tree tr : trs) {
            int t = bfs(last, tr);
            if (t == -1) return -1;
            res += t;
            last = tr;
        }
        return res;
    }

    public static void main(String[] args) {

        List<List<Integer>> forest = Build.build(new int[][]{
                {1, 2, 3},
                {0, 0, 4},
                {7, 6, 5}
        });
        System.out.println((new Solution()).cutOffTree(forest));  // 6
    }
}
