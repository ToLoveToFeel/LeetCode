package _0669_Trim_a_Binary_Search_Tree;

/**
 * Created by WXX on 2021/3/3 11:05
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了54.74%的用户
 */
public class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                0, 4,
                nu, 2, nu, nu,
                nu, nu, 1
        };
        MyTree myTree = new MyTree(nums);
        TreeNode root = myTree.getRoot();
        root = (new Solution()).trimBST(root, 1, 3);
        System.out.println(MyTree.levelOrder(root));
    }
}
