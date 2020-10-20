package _0110_Balanced_Binary_Tree;

/**
 * Date: 2020/10/20 8:58
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.90%的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了99.33%的用户
 */
public class Solution {
    // 返回以 root 为根的二叉树的深度 Leetcode 0104
    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).isBalanced(root));
    }
}
