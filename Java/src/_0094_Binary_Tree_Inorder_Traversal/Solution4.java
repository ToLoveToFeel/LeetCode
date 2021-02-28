package _0094_Binary_Tree_Inorder_Traversal;

import java.util.*;

/**
 * 经典非递归算法
 * 执行用时：1 ms, 在所有 Java 提交中击败了41.71%的用户
 * 内存消耗：36.9 MB, 在所有 Java 提交中击败了12.74%的用户
 */
public class Solution4 {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                nu, 2,
                nu, nu, 3
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution4()).inorderTraversal(root));
    }
}
