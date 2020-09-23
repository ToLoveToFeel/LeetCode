package _0617_Merge_Two_Binary_Trees;

/**
 * Date: 2020/9/23 10:00
 * Content:
 */
public class Solution {
    // 合并以 node1 和 node2 为根节点的两棵树， 结果存在 node1 中
    private void dfs(TreeNode node1, TreeNode node2) {
        if (node2 == null)  // 第二棵树为空，可以直接返回
            return;
        if (node1 != null) {  // 此时第二棵树不为空，第一棵树也不为空
            node1.val += node2.val;  // 更新第一棵树根节点的值
            if (node1.left == null)  // 第一棵树左节点为空
                node1.left = node2.left;
            else
                dfs(node1.left, node2.left);
            if (node1.right == null)  // 第一棵树右节点为空
                node1.right = node2.right;
            else
                dfs(node1.right, node2.right);
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null)
            return t1 == null ? t2 : t1;

        dfs(t1, t2);

        return t1;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums1 = new int[]{
                1,
                3, 2,
                5
        };
        int[] nums2 = new int[]{
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
