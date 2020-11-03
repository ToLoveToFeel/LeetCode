package _0000_study._leetcode._swordoffer._027_Mirror_Binary_Tree;

/**
 * Date: 2020/11/3 9:15
 * Content: 该题和Leetcode 0226一样
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36 MB, 在所有 Java 提交中击败了84.88%的用户
 */
public class Solution {

    // 该函数语义：反转以root为根的二叉树
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;

        mirrorTree(root.left);
        mirrorTree(root.right);

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
        System.out.println(MyTree.levelOrder((new Solution()).mirrorTree(root)));
    }
}
