package _0094_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归算法
 * 时间复杂度：O(n)，n为节点数目
 * 空间复杂度：O(h)，h为二叉树高度
 */
public class Solution2 {

    private class Command {
        String s;  // print：对节点操作, go：访问到该节点
        TreeNode node;

        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {
            Command command = stack.pop();
            if (command.s.equals("print"))
                res.add(command.node.val);
            else {
                assert command.s.equals("go");
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));

                stack.push(new Command("print", command.node));

                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
            }
        }
        return res;
    }
}
