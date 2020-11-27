package _0404_Sum_of_Left_Leaves;

/**
 * Date: 2020/9/19 8:48
 * Content:
 */
public class Solution2 {

    int res = 0;
    // 计算以 node 为根节点的二叉树的所有左叶子之和
    private void dfs(TreeNode node, boolean isLeft) {

        if (node == null)
            return;
        if (node.left == null && node.right == null && isLeft)
            res += node.val;

        dfs(node.left, true);
        dfs(node.right, false);
    }

    // 递归前序遍历
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return res;
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
        System.out.println((new Solution2()).sumOfLeftLeaves(root));
    }
}
