package _0662_Maximum_Width_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WXX on 2021/3/2 10:12
 * 执行用时：2 ms, 在所有 Java 提交中击败了69.33%的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了92.33%的用户
 */
public class Solution {

    static class MyPair {
        TreeNode x;
        int y;

        public MyPair(TreeNode x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        Queue<MyPair> q = new LinkedList<>();
        q.add(new MyPair(root, 1));
        int res = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            int l = q.peek().y, r = 0;

            for (int i = 0; i < sz; i++) {
                MyPair t = q.remove();
                TreeNode v = t.x;
                int p = t.y - l + 1;
                r = t.y;
                if (v.left != null) q.add(new MyPair(v.left, p * 2));
                if (v.right != null) q.add(new MyPair(v.right, p * 2 + 1));
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                3, 2,
                5, nu, nu, 9,
                6, nu, nu, nu, nu, nu, nu, 7
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).widthOfBinaryTree(root));  // 8
    }
}
