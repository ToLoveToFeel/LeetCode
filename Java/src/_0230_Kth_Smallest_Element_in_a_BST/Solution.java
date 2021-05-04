package _0230_Kth_Smallest_Element_in_a_BST;

/**
 * Date: 2021/5/4 17:57
 */
public class Solution {

    int k, ans;

    public int kthSmallest(TreeNode root, int _k) {
        k = _k;
        dfs(root);
        return ans;
    }

    private boolean dfs(TreeNode root) {  // 有返回值是为了当搜到答案时提前返回
        if (root == null) return false;
        if (dfs(root.left)) return true;
        if (--k == 0) {
            ans = root.val;
            return true;
        }
        return dfs(root.right);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                1, 4,
                nu, 2,
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).kthSmallest(root, 1));  // 1
    }
}
