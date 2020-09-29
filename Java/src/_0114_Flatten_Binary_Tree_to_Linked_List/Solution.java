package _0114_Flatten_Binary_Tree_to_Linked_List;

/**
 * Date: 2020/9/29 9:05
 * Content:
 * 关键点：左子树的最下最右的节点，是右子树的父节点.
 */
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // 找到左子树最右节点
                TreeNode pre = node.left;
                while (pre.right != null)
                    pre = pre.right;
                // 关键点：左子树的最下最右的节点，是右子树的父节点.
                pre.right = node.right;

                node.right = node.left;  // 统一规划到右子树
                node.left = null;

            }
            node = node.right;  // 考虑下一个节点
        }
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 5,
                3, 4, nu, 6
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        (new Solution()).flatten(root);
        System.out.println(MyTree.levelOrder(root));
    }
}
