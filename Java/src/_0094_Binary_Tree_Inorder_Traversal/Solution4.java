package _0094_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution4 {
    // 经典非递归算法，对应前序遍历的Solution4
    // 时间复杂度：O(n)，n为节点数目
    // 空间复杂度：O(h)，h为二叉树高度
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()){
            while (curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            res.add(curNode.val);
            curNode = curNode.right;
        }

        return res;
    }
}
