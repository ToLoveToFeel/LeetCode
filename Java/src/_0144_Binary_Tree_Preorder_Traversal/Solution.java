package _0144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法
 * 时间复杂度：O(n)，n为节点数目
 * 空间复杂度：O(h)，h为二叉树高度
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }
}
