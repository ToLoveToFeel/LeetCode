package _0222_Count_Complete_Tree_Nodes;

/**
 * Date: 2020/11/24 9:09
 * Content: 该解法对于任何二叉树都适合
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：40.8 MB, 在所有 Java 提交中击败了91.50%的用户
 */
public class Solution {

    private int count = 0;

    private void dfs(TreeNode node) {

        if (node != null) {
            count++;
            dfs(node.left);
            dfs(node.right);
        }
    }

    public int countNodes(TreeNode root) {

        dfs(root);
        return count;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 3,
                4, 5, 6, nu
        };

        TreeNode root = (new MyTree(nums)).getRoot();

        System.out.println((new Solution()).countNodes(root));
    }
}
