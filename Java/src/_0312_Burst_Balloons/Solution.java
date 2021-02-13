package _0312_Burst_Balloons;

/**
 * Date: 2021/2/13 9:10
 * Content:
 * 执行用时：91 ms, 在所有 Java 提交中击败了45.62%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了24.04%的用户
 */
public class Solution {

    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = a[n + 1] = 1;
        System.arraycopy(nums, 0, a, 1, n);

        int[][] f = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i + len - 1 <= n + 1; i++) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k++)
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + a[i] * a[k] * a[j]);
            }
        }

        return f[0][n + 1];
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 5, 8};
        System.out.println((new Solution()).maxCoins(nums));
    }
}
