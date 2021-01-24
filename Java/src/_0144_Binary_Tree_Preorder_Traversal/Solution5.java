package _0144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 另一种经典非递归算法
 * 时间复杂度：O(n)，n为节点数目
 * 空间复杂度：O(h)，h为二叉树高度
 */
public class Solution5 {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {  // 不能删除!stack.isEmpty()，因为当curNode==null时stack不一定为空
            if (curNode != null) {  // 当前节点的左孩子入栈
                res.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop();
                curNode = curNode.right;
            }
        }
        return res;
    }
}
