package _0000_study._algorithm.binarytreetraversal.postorder;

import _0000_study._algorithm.binarytreetraversal.MyTree;
import _0000_study._algorithm.binarytreetraversal.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Date: 2020/9/19 10:15
 * Content:
 * 前序遍历：递归
 */
public class Postorder {
    /*
        思路：后序遍历是：左右根，反过来就是：根右左； 按照根右左遍历后，再反过来
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> output = new ArrayDeque<>();
        TreeNode curNode = root;

        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                output.push(curNode);
                stack.push(curNode);
                curNode = curNode.right;
            }

            curNode = stack.pop();
            curNode = curNode.left;
        }
        while (!output.isEmpty())
            res.add(output.pop().val);
        return res;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                5,
                4, 8,
                11, nu, 13, 4,
                7, 2, nu, nu, nu, nu, 5, 1
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Postorder()).postorderTraversal(root));
    }
}
