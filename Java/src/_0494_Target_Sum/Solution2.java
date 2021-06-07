package _0494_Target_Sum;

/**
 * Date: 2021/6/7 9:24
 * 执行用时：28 ms, 在所有 Java 提交中击败了44.25%的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了37.11%的用户
 */
public class Solution2 {

    public int findTargetSumWays(int[] a, int target) {
        if (target < -1000 || target > 1000) return 0;
        int n = a.length, Offset = 1000;
        int[][] f = new int[n + 1][2001];
        f[0][Offset] = 1;  // 一个数都不选，总和为0是一种合法方案
        for (int i = 1; i <= n; i++)
            for (int j = -1000; j <= 1000; j++) {
                if (j - a[i - 1] >= -1000)
                    f[i][j + Offset] += f[i - 1][j - a[i - 1] + Offset];
                if (j + a[i - 1] <= 1000)
                    f[i][j + Offset] += f[i - 1][j + a[i - 1] + Offset];
            }
        return f[n][target + Offset];
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        System.out.println((new Solution2()).findTargetSumWays(nums, 3));  // 5
    }
}
