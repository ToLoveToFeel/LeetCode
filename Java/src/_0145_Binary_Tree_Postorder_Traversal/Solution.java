package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37 MB, 在所有 Java 提交中击败了5.32%的用户
 */
public class Solution {
    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        dfs(node.right);
        res.add(node.val);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                nu, 2,
                nu, nu, 3
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).postorderTraversal(root));
    }
}
