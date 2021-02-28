package _0144_Binary_Tree_Preorder_Traversal;

import java.util.*;

/**
 * 非递归算法
 * 执行用时：1 ms, 在所有 Java 提交中击败了45.75%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了30.16%的用户
 */
public class Solution4 {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stk.push(root);
                root = root.left;
            }
            root = stk.pop().right;
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
        System.out.println((new Solution4()).preorderTraversal(root));
    }
}
