package _0111_Minimum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/10/20 9:34
 * Content:
 * 层次遍历
 */
public class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right == null)
            return minDepth(root.left) + 1;
        else  // 左右子树都是非空
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
//        int[] nums = new int[]{
//                3,
//                9, 20,
//                nu, nu, 15, 7
//        };
        int[] nums = new int[]{
                2,
                nu, 3,
                nu, nu, nu, 4
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution2()).minDepth(root));
    }
}
