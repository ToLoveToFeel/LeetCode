package _0101_Symmetric_Tree;

/**
 * Date: 2020/9/27 11:02
 * Content:
 * https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
 */
public class Solution {
    // 检查以 p 和 q 为根的两颗子树是否是镜像对称的
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 2,
                3, 4, 4, 3
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).isSymmetric(root));
    }
}
