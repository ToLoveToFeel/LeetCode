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
}
