package _0530_Minimum_Absolute_Difference_in_BST;

/**
 * Date: 2020/10/12 8:34
 * Content: 中序遍历
 * 执行用时：1 ms, 在所有 Java 提交中击败了76.13%的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了93.14%的用户
 */
public class Solution2 {

    private int res = Integer.MAX_VALUE;
    private int last;
    private boolean isFirst = true;

    private void dfs(TreeNode root) {

        if (root == null)
            return;

        dfs(root.left);

        if (isFirst) {
            isFirst = false;
        } else {
            res = Math.min(res, root.val - last);
        }
        last = root.val;

        dfs(root.right);
    }

    public int getMinimumDifference(TreeNode root) {

        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                nu, 3,
                nu, nu, 2
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution2()).getMinimumDifference(root));
    }
}
