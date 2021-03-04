package _0671_Second_Minimum_Node_In_a_Binary_Tree;

/**
 * Created by WXX on 2021/3/4 14:45
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.6 MB, 在所有 Java 提交中击败了76.32%的用户
 */
public class Solution {

    long d1 = Long.MAX_VALUE, d2 = Long.MAX_VALUE;

    private void dfs(TreeNode root) {
        if (root == null) return;
        int x = root.val;
        if (x < d1) {
            d2 = d1;
            d1 = x;
        } else if (x > d1 && x < d2) d2 = x;
        dfs(root.left);
        dfs(root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (d2 == Long.MAX_VALUE) d2 = -1;
        return (int) d2;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                2,
                2, 5,
                nu, nu, 5, 7
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).findSecondMinimumValue(root));
    }
}
