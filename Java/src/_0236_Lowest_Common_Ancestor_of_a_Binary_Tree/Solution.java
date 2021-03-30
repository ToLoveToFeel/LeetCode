package _0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

/**
 * Date: 2020/9/27 9:43
 * Content: 后序遍历
 * 执行用时：7 ms, 在所有 Java 提交中击败了99.90%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了84.65%的用户
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
