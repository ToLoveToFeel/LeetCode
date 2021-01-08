package _0199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 当前层节点数
        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            for (int i = 0; i < levelNum; i++) {  // 遍历当前层所有节点
                TreeNode node = queue.remove();

                if (null != node.left) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (null != node.right) {
                    queue.add(node.right);
                    newLevelNum++;
                }
                if (levelNum - 1 == i)  // 遍历到最后一个节点
                    res.add(node.val);
            }
            levelNum = newLevelNum;
        }

        return res;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 3,
                nu, 5, nu, 4,
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).rightSideView(root));
    }
}
