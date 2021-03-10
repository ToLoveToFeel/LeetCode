package _0687_Longest_Univalue_Path;

/**
 * Created by WXX on 2021/3/10 19:39
 * 执行用时：3 ms, 在所有 Java 提交中击败了87.75%的用户
 * 内存消耗：42.3 MB, 在所有 Java 提交中击败了5.07%的用户
 */
public class Solution {

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        if (root.left != null && root.left.val != root.val) l = 0;
        if (root.right != null && root.right.val != root.val) r = 0;
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                4, 5,
                4, 4, nu, 5
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).longestUnivaluePath(root));  // 2
    }
}
