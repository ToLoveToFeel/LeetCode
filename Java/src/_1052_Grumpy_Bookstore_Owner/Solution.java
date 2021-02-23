package _1052_Grumpy_Bookstore_Owner;

/**
 * Date: 2021/2/23 9:46
 * Content:
 * 执行用时：2 ms, 在所有 Java 提交中击败了99.01%的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了5.93%的用户
 */
public class Solution {

    public int maxSatisfied(int[] c, int[] g, int X) {

        int n = c.length, res = 0;
        for (int i = 0; i < n; i++)
            if (i < X) res += c[i];
            else res += (1 - g[i]) * c[i];

        for (int i = X, j = 0, t = res; i < n; i++, j++) {
            t = t + g[i] * c[i] - g[j] * c[j];  // 滑动窗口[j + 1...i]
            res = Math.max(res, t);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] c = {1, 0, 1, 2, 1, 1, 7, 5}, g = {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        System.out.println((new Solution()).maxSatisfied(c, g, X));  // 16
    }
}
