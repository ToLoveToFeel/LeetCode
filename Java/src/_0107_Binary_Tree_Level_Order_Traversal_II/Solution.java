package _0107_Binary_Tree_Level_Order_Traversal_II;

import java.util.*;

/**
 * Date: 2020/9/6 7:45
 * Content:
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 当前遍历层的节点数目

        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            res.add(level);
            levelNum = newLevelNum;
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).levelOrderBottom(root));
    }
}
