package _0094_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了70.81%的用户
 */
public class Solution {
    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                nu, 2,
                nu, nu, 3
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).inorderTraversal(root));
    }
}
