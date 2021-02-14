package _0765_Couples_Holding_Hands;

import java.util.HashSet;

/**
 * Date: 2021/2/14 9:40
 * Content:
 * 思路：对每组情侣进行编号，那么组编号与情侣的对应关系为：
 * 0 : [0, 1]    1 : [2, 3]    2 : [4, 5]    3 : [6, 7]    4 : [8, 9]    5 : [10, 11] ......
 * 从前向后两两考虑，如果是情侣，直接跳过，如果不是情侣，合并这两个人所在的组。
 * 最后计算每个连通分量情侣组数(设为n)，则该组内交换n-1次就可让所有情侣坐在一起。
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了27.22%的用户
 * 内存消耗：35.7 MB, 在所有 Java 提交中击败了86.91%的用户
 */
public class Solution {

    public static final int N = 32;

    static int[] p = new int[N], cnt = new int[N];

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int minSwapsCouples(int[] row) {

        int n = row.length / 2;
        for (int i = 0; i < n; i++) {
            p[i] = i;
            cnt[i] = 1;
        }
        for (int i = 0; i < row.length; i += 2) {
            int a = row[i] / 2, b = row[i + 1] / 2;
            if (a == b) continue;
            a = find(a);
            b = find(b);
            if (a != b) {
                p[a] = b;
                cnt[b] += cnt[a];
            }
        }

        int res = 0;
        HashSet<Integer> hash = new HashSet<>();
        for (int x : row) {
            int r = find(x / 2);
            if (!hash.contains(r)) {
                res += cnt[r] - 1;
                hash.add(r);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] row = {5, 4, 2, 6, 3, 1, 0, 7};
        System.out.println((new Solution()).minSwapsCouples(row));  // 2
    }
}
