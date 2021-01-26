package _0096_Unique_Binary_Search_Trees;

/**
 * Date: 2021/1/26 10:50
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.2 MB, 在所有 Java 提交中击败了59.32%的用户
 */
public class Solution {

    public int numTrees(int n) {

        // f[i]: 表示一共i个不同的节点可以组成的二叉搜索树的个数
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                f[i] += f[j - 1] * f[i - j];
        return f[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).numTrees(3));  // 5
    }
}
