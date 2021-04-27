package _0938_Range_Sum_of_BST;

/**
 * Date: 2021/4/27 9:31
 * 执行用时：1 ms, 在所有 Java 提交中击败了55.17%的用户
 * 内存消耗：46.6 MB, 在所有 Java 提交中击败了18.53%的用户
 */
public class Solution {

    int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }

    private void dfs(TreeNode root, int l, int r) {
        if (root == null) return;
        dfs(root.left, l, r);
        if (root.val >= l && root.val <= r) ans += root.val;
        dfs(root.right, l, r);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                10,
                5, 15,
                3, 7, nu, 18
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).rangeSumBST(root, 7, 15));  // 32
    }
}
