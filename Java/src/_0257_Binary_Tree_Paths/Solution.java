package _0257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度：O(n)，n为结点个数
 * 空间复杂度：O(h)，h为树高
 */
public class Solution {

    // 函数语义：返回以root为根的所有的路径字符串
    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);  // 左子树所有路径字符串
        for (String s : leftPaths) {  // 拼接上左子树的父结点
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            res.add(sb.append("->").append(s).toString());
        }
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String s : rightPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            res.add(sb.append("->").append(s).toString());
        }

        return res;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 3,
                nu, 5
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).binaryTreePaths(root));
    }
}
