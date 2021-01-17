package _0101_Symmetric_Tree;

/**
 * Date: 2020/9/27 11:02
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了36.34%的用户
 */
public class Solution {

    // 检查以 p 和 q 为根的两颗子树是否是镜像对称的
    private boolean dfs(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {

        return dfs(root, root);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]ns

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).isSymmetric(root));
    }
}
