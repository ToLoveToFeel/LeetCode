package _0062_Unique_Paths;

/**
 * Date: 2020/12/9 15:49
 * Content:
 * 数学：横向需要走 n - 1 步，纵向需要走 m - 1 步
 * 从 m+n-2 步中选择： m-1 个纵向的步骤 / 或者 n-1 个横向的步骤
 * 组合：C(a, b) = a! / (b! * (a-b)!) = ((b+1)*...*a) / (a-b)!
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.3 MB, 在所有 Java 提交中击败了73.02%的用户
 */
public class Solution {

    public int uniquePaths(int m, int n) {

        long res = 1;

        int len = Math.min(m - 1, n - 1);
        for (int i = 0; i < len; i++) {
            res *= (m + n - 2 - i);
            res /= (i + 1);
        }

        return (int) res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).uniquePaths(3, 7));  // 28
        System.out.println((new Solution()).uniquePaths(3, 2));  // 3
        System.out.println((new Solution()).uniquePaths(7, 3));  // 28
        System.out.println((new Solution()).uniquePaths(3, 3));  // 6
    }
}
