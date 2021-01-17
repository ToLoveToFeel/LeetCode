package _0104_Maximum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    // BFS
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 记录当前层的数量
        int maxDepth = 0;  // 记录深度

        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            maxDepth++;
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.remove();

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
        }
        return maxDepth;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution2()).maxDepth(root));
    }
}
