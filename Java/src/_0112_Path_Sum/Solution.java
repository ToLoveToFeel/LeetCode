package _0112_Path_Sum;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root)  // 节点为空
            return false;

        if (null == root.left && null == root.right)  //若为叶子节点
            return root.val == sum;

        // 否则，查看左右子树是否存在sum-root.val的路径
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                5,
                4, 8,
                11, nu, 13, 4,
                7, 2, nu, nu, nu, nu, 5, 1
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        int sum = 22;
        System.out.println((new Solution()).hasPathSum(root, sum));
    }
}
