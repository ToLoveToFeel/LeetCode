package _0000_study._algorithm.binarytreetraversal.postorder;

import _0000_study._algorithm.binarytreetraversal.MyTree;
import _0000_study._algorithm.binarytreetraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/19 10:15
 * Content:
 * 前序遍历：递归
 */
public class PostorderRecursion {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            postorderTraversal(node.left, res);
            postorderTraversal(node.right, res);
            res.add(node.val);
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
        System.out.println((new PostorderRecursion()).postorderTraversal(root));
    }
}
