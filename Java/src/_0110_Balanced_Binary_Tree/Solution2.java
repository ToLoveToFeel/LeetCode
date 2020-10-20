package _0110_Balanced_Binary_Tree;

/**
 * Date: 2020/10/20 8:58
 * Content:
 * https://leetcode-cn.com/problems/balanced-binary-tree/solution/balanced-binary-tree-di-gui-fang-fa-by-jin40789108/
 */
public class Solution2 {
    // 后续遍历, 如果以 root 为根的子树平衡，返回该树的深度（高度），否则返回 -1
    private int recur(TreeNode root) {
        if (root == null)  // 空树高度为 0
            return 0;

        int leftHeight = recur(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = recur(root.right);
        if (rightHeight == -1)
            return -1;

        return Math.abs(leftHeight - rightHeight) <= 1 ?
                Math.max(leftHeight, rightHeight) + 1 : -1;
    }

    public boolean isBalanced(TreeNode root) {
        // 此时如果根节点的左右深度之差的返回值不为-1,即为正确的
        return recur(root) != -1;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution2()).isBalanced(root));
    }
}
