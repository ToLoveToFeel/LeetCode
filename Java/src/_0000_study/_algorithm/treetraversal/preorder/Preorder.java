package _0000_study._algorithm.treetraversal.preorder;

import _0000_study._algorithm.treetraversal.MyTree;
import _0000_study._algorithm.treetraversal.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Date: 2020/9/19 10:15
 * Content:
 * 前序遍历：递归
 */
public class Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {  // 不能删除!stack.isEmpty()，因为当curNode==null时stack不一定为空
            while (curNode != null) {  // 当前节点的左孩子，以及左孩子的左孩子......全部入栈
                res.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            curNode = curNode.right;
        }
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
        System.out.println((new Preorder()).preorderTraversal(root));
    }
}
