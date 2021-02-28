package _0337_House_Robber_III;

/**
 * Created by WXX on 2021/2/28 10:13
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了5.44%的用户
 */
public class Solution {

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] x = dfs(root.left), y = dfs(root.right);
        return new int[]{Math.max(x[0], x[1]) + Math.max(y[0], y[1]), x[0] + y[0] + root.val};
    }

    public int rob(TreeNode root) {
        int[] f = dfs(root);
        return Math.max(f[0], f[1]);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                2, 3,
                nu, 3, nu, 1
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).rob(root));  // 7
    }
}
