package _0104_Maximum_Depth_of_Binary_Tree;

public class Solution {

    // 返回以root为根的树的高度
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).maxDepth(root));
    }
}
