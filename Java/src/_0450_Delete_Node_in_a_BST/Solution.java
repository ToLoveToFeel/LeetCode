package _0450_Delete_Node_in_a_BST;

/**
 * Date: 2021/6/3 21:10
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode p = root.right;
                while (p.left != null) p = p.left;  // 找后继
                root.val = p.val;
                root.right = deleteNode(root.right, p.val);
            }
        }
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                5,
                3, 6,
                2, 4, nu, 7
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        root = (new Solution()).deleteNode(root, 3);
        System.out.println(MyTree.levelOrder(root));  // [[5], [4, 6], [2, 7]]
    }
}
