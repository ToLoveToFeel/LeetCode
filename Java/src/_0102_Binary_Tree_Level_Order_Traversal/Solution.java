package _0102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 执行用时：2 ms, 在所有 Java 提交中击败了10.39%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了14.58%的用户
 */
public class Solution {

    private static class MyPair {
        TreeNode node;
        int val;

        public MyPair(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<MyPair> q = new LinkedList<>();  // q作为队列
        q.add(new MyPair(root, 0));
        while (!q.isEmpty()) {
            MyPair front = q.remove();
            TreeNode node = front.node;
            int level = front.val;

            if (level == res.size()) res.add(new ArrayList<>());

            res.get(level).add(node.val);
            if (null != node.left) q.add(new MyPair(node.left, level + 1));
            if (null != node.right) q.add(new MyPair(node.right, level + 1));
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
        System.out.println((new Solution()).levelOrder(root));
    }
}
