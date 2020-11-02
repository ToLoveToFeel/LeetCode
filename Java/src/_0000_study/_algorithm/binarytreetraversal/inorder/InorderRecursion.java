package _0000_study._algorithm.binarytreetraversal.inorder;

import _0000_study._algorithm.binarytreetraversal.MyTree;
import _0000_study._algorithm.binarytreetraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/19 10:15
 * Content:
 * 中序遍历：递归
 */
public class InorderRecursion {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            inorderTraversal(node.left, res);
            res.add(node.val);
            inorderTraversal(node.right, res);
        }
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
        System.out.println((new InorderRecursion()).inorderTraversal(root));
    }
}
