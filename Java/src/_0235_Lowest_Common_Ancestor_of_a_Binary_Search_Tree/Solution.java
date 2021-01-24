package _0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

/**
 * 执行用时：6 ms, 在所有 Java 提交中击败了99.37%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了30.59%的用户
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                6,
                2, 8,
                0, 4, 7, 9,
                nu, nu, 3, 5
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).
                lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
        System.out.println((new Solution()).
                lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
    }
}
