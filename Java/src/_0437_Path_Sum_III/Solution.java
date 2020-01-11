package _0437_Path_Sum_III;

public class Solution {
    // 在以root为根结点的二叉树中，寻找和为sum的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
        if (null == root)
            return 0;

        int res = findPath(root, sum);  // 包含结点root其和为sum的个数
        res += pathSum(root.left, sum);  // 进入左子树，寻找和为sum的路径
        res += pathSum(root.right, sum);  // 进入右子树，寻找和为sum的路径

        return res;
    }

    // 在以node为根结点的二叉树中，寻找包含node的路径，和为sum
    // 返回这样的路径个数
    private int findPath(TreeNode node, int sum){
        if (null == node)
            return 0;
        int res = 0;
        if (node.val == sum)
            res += 1;

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);

        return res;
    }
}
