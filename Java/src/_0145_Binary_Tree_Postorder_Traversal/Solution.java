package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法
 * 时间复杂度：O(n)，n为节点数目
 * 空间复杂度：O(h)，h为二叉树高度
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            postorderTraversal(node.left, list);
            postorderTraversal(node.right, list);
            list.add(node.val);
        }
    }
}
