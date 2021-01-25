package _0959_Regions_Cut_By_Slashes;

/**
 * Date: 2021/1/25 10:33
 * Content: 并查集
 * 执行用时：4 ms, 在所有 Java 提交中击败了91.75%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了88.42%的用户
 */
public class Solution {

    public static final int N = 35;

    static int[] p = new int[N * N * 4];
    static int cnt;

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            p[a] = b;
            cnt--;
        }
    }

    public int regionsBySlashes(String[] grid) {

        int n = grid.length;
        cnt = n * n * 4;
        for (int i = 0; i < cnt; i++) p[i] = i;  // 初始化并查集

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                if (i < n - 1) merge(id * 4 + 2, (id + n) * 4 + 0);
                if (j < n - 1) merge(id * 4 + 1, (id + 1) * 4 + 3);

                if (grid[i].charAt(j) == '/') {
                    merge(id * 4 + 0, id * 4 + 3);  // 上、左
                    merge(id * 4 + 1, id * 4 + 2);  // 右、下
                } else if (grid[i].charAt(j) == '\\') {
                    merge(id * 4 + 0, id * 4 + 1);  // 上、右
                    merge(id * 4 + 2, id * 4 + 3);  // 下、左
                } else {
                    merge(id * 4 + 0, id * 4 + 1);  // 上、右
                    merge(id * 4 + 1, id * 4 + 2);  // 右、下
                    merge(id * 4 + 2, id * 4 + 3);  // 下、左
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        String[] grid = {"/\\", "\\/"};  // 5
        System.out.println((new Solution()).regionsBySlashes(grid));
    }
}
