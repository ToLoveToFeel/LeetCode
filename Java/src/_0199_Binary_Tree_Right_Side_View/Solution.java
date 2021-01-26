package _0199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {  // 遍历当前层所有节点
                TreeNode node = q.remove();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                if (i == len - 1) res.add(node.val);
            }
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
