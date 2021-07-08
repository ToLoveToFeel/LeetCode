package _0968_Binary_Tree_Cameras;

/**
 * Date: 2021/7/8 22:04
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了40.37%的用户
 */
public class Solution {

    static int INF = (int) (1e8);

    public int minCameraCover(TreeNode root) {
        int[] f = dfs(root);
        return Math.min(f[1], f[2]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0, INF};
        int[] l = dfs(root.left), r = dfs(root.right);
        return new int[]{
                Math.min(l[1], l[2]) + Math.min(r[1], r[2]),
                Math.min(l[2] + Math.min(r[1], r[2]), r[2] + Math.min(l[1], l[2])),
                Math.min(l[0], Math.min(l[1], l[2])) + Math.min(r[0], Math.min(r[1], r[2])) + 1,
        };
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                1, nu,
                1, 1,
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).minCameraCover(root));  // 1
    }
}
