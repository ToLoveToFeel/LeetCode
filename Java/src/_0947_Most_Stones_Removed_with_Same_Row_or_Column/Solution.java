package _0947_Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2021/1/15 16:18
 * Content:
 * 执行用时：35 ms, 在所有 Java 提交中击败了46.77%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了27.41%的用户
 */
public class Solution {

    public static final int N = 1010;

    static int[] p = new int[N], sz = new int[N];

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;  // 石子个数
        for (int i = 0; i < n; i++) {  // 初始化并查集
            p[i] = i;
            sz[i] = 1;
        }

        // 合并元素
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int p1 = find(i), p2 = find(j);
                    if (p1 != p2) {
                        p[p1] = p2;
                        sz[p2] += sz[p1];
                    }
                }
        }

        // 每个连通分量需要删除 sz[i] - 1 个元素
        int res = 0;
        Set<Integer> set = new HashSet<>();  // 防止重复计算
        for (int i = 0; i < n; i++) {
            int t = find(i);
            if (!set.contains(t)) {
                res += sz[t] - 1;
                set.add(t);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};  // 5
//        int[][] stones = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};  // 3
//        int[][] stones = {{0, 0}};  // 0
        System.out.println((new Solution()).removeStones(stones));

    }
}
