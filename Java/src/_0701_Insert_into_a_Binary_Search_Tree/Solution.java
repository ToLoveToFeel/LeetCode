package _0701_Insert_into_a_Binary_Search_Tree;

/**
 * Date: 2020/9/30 9:50
 * Content:
 * 非递归
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)  // 原本就是空树
            return new TreeNode(val);
        // 寻找应该插入到的叶子节点位置
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            pre = cur;
            if (val < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if (val < pre.val)
            pre.left = new TreeNode(val);
        else
            pre.right = new TreeNode(val);

        return root;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                4,
                2, 7,
                1, 3
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        root = (new Solution()).insertIntoBST(root, 5);
        System.out.println(MyTree.levelOrder(root));
    }
}
