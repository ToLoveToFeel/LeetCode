package _0102_Binary_Tree_Level_Order_Traversal;

import java.util.*;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了93.85%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了56.38%的用户
 */
public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 当前层的节点数

        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {  // 遍历当前层的所有节点
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
        System.out.println((new Solution2()).levelOrder(root));
    }
}
