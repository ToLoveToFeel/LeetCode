package _0094_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法
 * 时间复杂度：O(n)，n为节点数目
 * 空间复杂度：O(h)，h为二叉树高度
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
        }
    }
}
