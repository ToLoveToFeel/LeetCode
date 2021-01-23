package _0098_Validate_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/11 9:37
 * Content:
 * 思路：中序遍历后（递归），判断是否是递增的数组
 */
public class Solution {
    private List<Integer> list;

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        // 第一步：中序遍历，将结果存入 list 中
        list = new ArrayList<>();
        inorder(root);

        // 第二步：判断是否是严格递增的
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i) >= list.get(i + 1))
                return false;

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
        System.out.println((new Solution()).isValidBST(root));
    }
}
