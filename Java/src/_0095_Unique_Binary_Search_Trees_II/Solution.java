package _0095_Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/1/26 10:58
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.90%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了62.99%的用户
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int l, int r) {

        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = dfs(l, i - 1), right = dfs(i + 1, r);
            for (TreeNode a : left)
                for (TreeNode b : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = a;
                    root.right = b;
                    res.add(root);
                }
        }
        return res;
    }

    public static void main(String[] args) {

        List<TreeNode> res = (new Solution()).generateTrees(3);
        for (TreeNode root : res) {
            System.out.println(MyTree.levelOrder(root));
        }
    }
}
