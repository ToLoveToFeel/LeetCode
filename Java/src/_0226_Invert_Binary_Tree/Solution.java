package _0226_Invert_Binary_Tree;

public class Solution {
    // 该函数语义：反转以root为根的二叉树
    // 时间复杂度：O(n)，n为节点个数
    // 时间复杂度：O(h)，h为二叉树高度
    public TreeNode invertTree(TreeNode root) {
        if (null == root)
            return root;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        return root;
    }
}
