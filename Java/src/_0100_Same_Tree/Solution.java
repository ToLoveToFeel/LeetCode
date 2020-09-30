package _0100_Same_Tree;

/**
 * Date: 2020/9/30 10:23
 * Content:
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)  // 说明 p 和 q 有一个为空
            return false;
        else  // 说明 p 和 q 均不为空
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums1 = new int[]{
                1,
                2, 3
        };
        int[] nums2 = new int[]{
                1,
                2, 4
        };

        TreeNode root1 = (new MyTree(nums1)).getRoot();
        TreeNode root2 = (new MyTree(nums2)).getRoot();
        System.out.println((new Solution()).isSameTree(root1, root2));
    }
}
