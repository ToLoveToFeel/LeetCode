package _0655_Print_Binary_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WXX on 2021/3/1 9:40
 * 执行用时：7 ms, 在所有 Java 提交中击败了17.27%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了75.09%的用户
 */
public class Solution {

    String[][] ans;

    // 返回以root为根的树的高度和宽度
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = dfs(root.left), r = dfs(root.right);
        return new int[]{Math.max(l[0], r[0]) + 1, Math.max(l[1], r[1]) * 2 + 1};
    }

    // h: 层数，l：左边界，r：右边界
    private void print(TreeNode root, int h, int l, int r) {
        if (root == null) return;
        int mid = (l + r) / 2;
        ans[h][mid] = root.val + "";
        print(root.left, h + 1, l, mid - 1);
        print(root.right, h + 1, mid + 1, r);
    }

    private List<List<String>> build(String[][] s) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            List<String> e = new ArrayList<>();
            for (int j = 0; j < s[i].length; j++) e.add(s[i][j]);
            res.add(e);
        }
        return res;
    }

    public List<List<String>> printTree(TreeNode root) {
        // 求出树的高度和宽度
        int[] t = dfs(root);
        int h = t[0], w = t[1];

        ans = new String[h][w];
        for (int i = 0; i < h; i++) Arrays.fill(ans[i], "");
        print(root, 0, 0, w - 1);
        return build(ans);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 3,
                nu, 4
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).printTree(root));
    }
}
