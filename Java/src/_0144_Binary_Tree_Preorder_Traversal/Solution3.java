package _0144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    // 经典非递归算法
    // 时间复杂度：O(n)，n为节点数目
    // 空间复杂度：O(h)，h为二叉树高度

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (null == root)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode curNode = stack.pop();
            res.add(curNode.val);

            if (curNode.right != null)
                stack.push(curNode.right);
            if (curNode.left != null)
                stack.push(curNode.left);
        }
        return res;
    }
}
