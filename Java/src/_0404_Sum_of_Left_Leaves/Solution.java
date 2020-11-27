package _0404_Sum_of_Left_Leaves;

/**
 * Date: 2020/9/19 8:48
 * Content:
 */
public class Solution {

    // 返回以root为根的二叉树的所有左叶子之和
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return 0;

        if (root.left != null && root.right != null) {  // 左右都是非空
            if (root.left.left == null && root.left.right == null)  // root.left 是叶子节点
                return root.left.val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            else  // root.left 不是叶子节点
                return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        } else if (root.left != null) {  // 右子树为空
            if (root.left.left == null && root.left.right == null)  // root.left 是叶子节点
                return root.left.val + sumOfLeftLeaves(root.left);
            else
                return sumOfLeftLeaves(root.left);
        } else if (root.right != null)  // 左子树为空
            return sumOfLeftLeaves(root.right);
        else  // 左右子树都为空
            return 0;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
//        int[] nums = new int[]{
//                3,
//                9, 20,
//                nu, nu, 15, 7
//        };
        int[] nums = new int[]{
                1,
                2, 3,
                4, 5, nu, nu
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).sumOfLeftLeaves(root));
    }
}
