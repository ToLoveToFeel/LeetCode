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

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                4,
                2, 7,
                1, 3, 6, 9
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println(MyTree.levelOrder((new Solution()).invertTree(root)));
    }
}
