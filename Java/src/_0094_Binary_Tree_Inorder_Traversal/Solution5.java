package _0094_Binary_Tree_Inorder_Traversal;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 另一种经典非递归算法
 * 时间复杂度：O(n)，n为节点数目
 * 空间复杂度：O(h)，h为二叉树高度
 */
public class Solution5 {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
