package _0144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution4 {
    // 另一种经典非递归算法
    // 时间复杂度：O(n)，n为节点数目
    // 空间复杂度：O(h)，h为二叉树高度

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (null == root)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()){  // 不能删除!stack.isEmpty()，因为当curNode==null时stack不一定为空
            while (curNode != null){  // 当前节点的左孩子，以及左孩子的左孩子......全部入栈
                res.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            curNode = curNode.right;
        }
        return res;
    }
}
