package _0103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2020/9/30 10:42
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了98.42%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了60.77%的用户
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 当前层节点数目
        int deepth = 0;  // 当前所处的层的位置，从 0 开始

        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {

                TreeNode node = queue.remove();

                if ((deepth & 1) == 0)
                    level.add(node.val);
                else
                    level.add(0, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            levelNum = newLevelNum;
            deepth++;
            res.add(level);
        }
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
        List<List<Integer>> res = (new Solution()).zigzagLevelOrder(root);
        System.out.println(res);
    }
}
