package _0993_Cousins_in_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2021/5/17 9:34
 */
public class Solution {

    static class MyPair {
        TreeNode cur, p;  // 当前节点，父节点
        int d;  // 当前节点深度
        public MyPair(TreeNode cur, TreeNode p, int d) {
            this.cur = cur; this.p = p; this.d = d;
        }
    }
    TreeNode p1 = null, p2 = null;
    int d1 = 0, d2 = 0;

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<MyPair> q = new LinkedList<>();
        q.add(new MyPair(root, null, 0));
        while (!q.isEmpty()) {
            MyPair t = q.remove();
            if (t.cur.val == x) { p1 = t.p; d1 = t.d; }
            if (t.cur.val == y) { p2 = t.p; d2 = t.d; }
            if (p1 != null && p2 != null) break;  // 找到两个节点，提前退出
            if (t.cur.left != null) q.add(new MyPair(t.cur.left, t.cur, t.d + 1));
            if (t.cur.right != null) q.add(new MyPair(t.cur.right, t.cur, t.d + 1));
        }
        return d1 == d2 && p1 != p2;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 3,
                nu, 4, nu, 5
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).isCousins(root, 5, 4));  // true
    }
}
