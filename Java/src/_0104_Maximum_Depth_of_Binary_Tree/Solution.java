package _0104_Maximum_Depth_of_Binary_Tree;

public class Solution {
    // 递归算法
    // 该函数语义：返回以root为根的树的高度
    public int maxDepth(TreeNode root) {
        if (null == root)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
