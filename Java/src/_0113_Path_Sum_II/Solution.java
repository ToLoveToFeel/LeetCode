package _0113_Path_Sum_II;

import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/4 15:31
 * Content:
 */
class Solution {

    // 将以node为根节点，且 tsum + node.val == sum 的路径添加到res中
    // tres记录当前的路径
    private void dfs(TreeNode node, LinkedList<Integer> tres, int tsum, int sum, List<List<Integer>> res) {
        tres.add(node.val);
        tsum += node.val;

        if (node.left == null && node.right == null) {
            if (tsum == sum)
                res.add((LinkedList<Integer>) tres.clone());
        } else {
            if (node.left != null)
                dfs(node.left, tres, tsum, sum, res);
            if (node.right != null)
                dfs(node.right, tres, tsum, sum, res);
        }
        tres.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;

        LinkedList<Integer> tres = new LinkedList<>();
        dfs(root, tres, 0, sum, res);
        return res;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                5,
                4, 8,
                11, nu, 13, 4,
                7, 2, nu, nu, nu, nu, 5, 1
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        int sum = 22;
        System.out.println((new Solution()).pathSum(root, sum));
    }
}
