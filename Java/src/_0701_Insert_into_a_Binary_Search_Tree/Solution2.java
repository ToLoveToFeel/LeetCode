package _0701_Insert_into_a_Binary_Search_Tree;

/**
 * Date: 2020/9/30 9:50
 * Content:
 * 递归
 */
public class Solution2 {
    // 向以 root 为根的树中添加值为 val 的节点，并返回插入 val 后的根节点
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)  // 原本就是空树
            return new TreeNode(val);

        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else if (val > root.val)
            root.right = insertIntoBST(root.right, val);

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
        root = (new Solution2()).insertIntoBST(root, 5);
        System.out.println(MyTree.levelOrder(root));
    }
}
