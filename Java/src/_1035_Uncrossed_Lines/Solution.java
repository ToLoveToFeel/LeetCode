package _1035_Uncrossed_Lines;

/**
 * Date: 2021/5/21 8:40
 * 执行用时：6 ms, 在所有 Java 提交中击败了60.90%的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了72.30%的用户
 */
public class Solution {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (nums1[i - 1] == nums2[j - 1]) f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }
        return f[n][m];
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 4, 2}, nums2 = {1, 2, 4};
        System.out.println((new Solution()).maxUncrossedLines(nums1, nums2));  // 2
    }
}
