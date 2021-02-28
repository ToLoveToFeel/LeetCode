package _0102_Binary_Tree_Level_Order_Traversal;

import java.util.*;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了94.42%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了21.83%的用户
 */
public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode t = q.remove();
                level.add(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution2()).levelOrder(root));
    }
}
