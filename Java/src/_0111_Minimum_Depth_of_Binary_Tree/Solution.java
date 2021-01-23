package _0111_Minimum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/10/20 9:34
 * Content: 层次遍历
 */
public class Solution {

    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int minDepth = 1;  // 最小深度
        int levelNum = 1;

        while (true) {  // 一定可以返回
            int newLevelNum = 0;
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.remove();
                if (node.left == null && node.right == null)
                    return minDepth;
                if (node.left != null) {
                    q.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    q.add(node.right);
                    newLevelNum++;
                }
            }
            minDepth++;
            levelNum = newLevelNum;
        }
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };
//        int[] nums = new int[]{
//                2,
//                nu, 3,
//                nu, nu, nu, 4
//        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).minDepth(root));
    }
}
