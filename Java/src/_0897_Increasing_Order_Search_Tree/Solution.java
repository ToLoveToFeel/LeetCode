package _0897_Increasing_Order_Search_Tree;

/**
 * Date: 2021/4/25 10:52
 */
public class Solution {

    TreeNode preNode = new TreeNode(-1);

    public TreeNode increasingBST(TreeNode root) {

        TreeNode dummy = new TreeNode(-1);  // 虚拟头结点
        preNode = dummy;
        dfs(root);
        return dummy.right;
    }

    private void dfs(TreeNode node) {

        if (node == null) return;

        dfs(node.left);

        preNode.right = node;  // 第一次执行这句话时, preNode就是dummy, 会让dummy.right指向新树头结点
        node.left = null;
        preNode = node;  // 之后preNode会被重新赋值，preNode != dummy

        dfs(node.right);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                5,
                1, 7
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println(MyTree.levelOrder((new Solution()).increasingBST(root)));
    }
}
