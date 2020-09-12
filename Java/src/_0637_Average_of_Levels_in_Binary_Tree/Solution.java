package _0637_Average_of_Levels_in_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2020/9/12 21:40
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 当前层节点个数

        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            double sum = 0.0;
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            res.add(sum / levelNum);
            levelNum = newLevelNum;
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
        System.out.println((new Solution()).averageOfLevels(root));
    }
}
