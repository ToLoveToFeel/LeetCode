package _0530_Minimum_Absolute_Difference_in_BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/12 8:34
 * Content:
 * 中序遍历后得到排序后的数组，然后计算最小绝对差
 */
public class Solution {

    private List<TreeNode> list;

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            list.add(node);
            inorder(node.right);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();

        // 中序遍历
        inorder(root);

        // 计算最小绝对差
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            res = Math.min(res, list.get(i + 1).val - list.get(i).val);
        }

        return res;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                nu, 3,
                nu, nu, 2
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).getMinimumDifference(root));
    }
}
