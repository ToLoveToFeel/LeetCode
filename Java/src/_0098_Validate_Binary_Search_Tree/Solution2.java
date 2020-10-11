package _0098_Validate_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Date: 2020/10/11 9:37
 * Content:
 * 思路：中序遍历后（非递归），判断是否是递增的数组
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        double preValue = -Double.MAX_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            if (curNode.val <= preValue)
                return false;
            preValue = curNode.val;
            curNode = curNode.right;
        }

        return true;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
//        int[] nums = new int[]{
//                2,
//                1, 3
//        };
        int[] nums = new int[]{
                5,
                1, 4,
                nu, nu, 3, 6
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution2()).isValidBST(root));
    }
}
