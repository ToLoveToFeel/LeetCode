package _0000_study._algorithm.treetraversal.preorder;

import _0000_study._algorithm.treetraversal.MyTree;
import _0000_study._algorithm.treetraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/19 10:15
 * Content:
 * 前序遍历：递归
 */
public class PreorderRecursion {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            preorderTraversal(node.left, res);
            preorderTraversal(node.right, res);
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
        System.out.println((new PreorderRecursion()).preorderTraversal(root));
    }
}
