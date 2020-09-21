package _0538_Convert_BST_to_Greater_Tree;

/**
 * Date: 2020/9/21 8:14
 * Content:
 * BST 中序遍历 是 有序的
 * 反向中序遍历：左根右 --> 右根左
 */
public class Solution {
    int sum = 0;

    // 将以 root 为根的 BST 转为累加树
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                5,
                3, 13,
                nu, 4, 7, 16
        };

        MyTree myTree = new MyTree(nums);
        TreeNode root = myTree.getRoot();
        (new Solution()).convertBST(root);
        System.out.println(myTree.levelOrder());
    }
}
