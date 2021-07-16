package _0617_Merge_Two_Binary_Trees;

/**
 * Date: 2020/9/23 10:00
 * Content:
 */
public class Solution {

    // 合并以 node1 和 node2 为根节点的两棵树， 结果存在 node1 中
    private void dfs(TreeNode node1, TreeNode node2) {

        if (node2 == null) return;  // 第二棵树为空，可以直接返回
        if (node1 != null) {
            node1.val += node2.val;  // 更新第一棵树根节点的值
            if (node1.left == null) node1.left = node2.left;  // 第一棵树左节点为空
            else dfs(node1.left, node2.left);

            if (node1.right == null) node1.right = node2.right; // 第一棵树右节点为空
            else dfs(node1.right, node2.right);
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) return t2;
        if (t2 == null) return t1;

        dfs(t1, t2);
        return t1;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums1 = {
                1,
                3, 2,
                5
        };
        int[] nums2 = {
                2,
                1, 3,
                nu, 4, nu, 7
        };

        TreeNode root1 = (new MyTree(nums1)).getRoot();
        TreeNode root2 = (new MyTree(nums2)).getRoot();
        TreeNode newRoot = (new Solution()).mergeTrees(root1, root2);

        System.out.println(MyTree.levelOrder(newRoot));
    }
}
