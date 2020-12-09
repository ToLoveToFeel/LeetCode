package _0062_Unique_Paths;

import java.util.Arrays;

/**
 * Date: 2020/12/9 15:49
 * Content: 动态规划
 * 优化Solution2的空间复杂度
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(n)
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了86.44%的用户
 */
public class Solution3 {

    public int uniquePaths(int m, int n) {

        // 因为只需要上一行和左边的值，所以一维数组就行
        int[] row = new int[n];  // 存储某一行
        Arrays.fill(row, 1);

        for (int i = 1; i < m; i++) {
            int left = 1;
            for (int j = 1; j < n; j++) {
                row[j] += left;
                left = row[j];
            }
        }

        return row[n - 1];
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).uniquePaths(3, 7));  // 28
        System.out.println((new Solution3()).uniquePaths(3, 2));  // 3
        System.out.println((new Solution3()).uniquePaths(7, 3));  // 28
        System.out.println((new Solution3()).uniquePaths(3, 3));  // 6
    }
}
