package _0987_Vertical_Order_Traversal_of_a_Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


/**
 * Date: 2021/7/31 15:13
 * Content:
 * 执行用时：3 ms, 在所有 Java 提交中击败了80.35%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了27.27%的用户
 */
public class Solution {

    TreeMap<Integer, List<int[]>> S = new TreeMap<>();

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) return;

        if (!S.containsKey(y)) S.put(y, new ArrayList<>());
        S.get(y).add(new int[]{x, root.val});

        dfs(root.left, x + 1, y - 1);
        dfs(root.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        for (int k : S.keySet()) {
            List<int[]> v = S.get(k);
            v.sort(((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }));
            List<Integer> col = new ArrayList<>();
            for (int[] p : v) col.add(p[1]);
            res.add(col);
        }
        return res;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = {
                3,
                9, 20,
                nu, nu, 15, 7
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).verticalTraversal(root));
    }
}
