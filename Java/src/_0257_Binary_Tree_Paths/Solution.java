package _0257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 时间复杂度：O(n)，n为结点个数
    // 空间复杂度：O(h)，h为树高
    // 函数语义：返回以root为根的所有的路径字符串
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();

        if (null == root)
            return res;

        if (root.left == null && root.right == null) {  // 递归终止情况
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);  // 左子树所有路径字符串
        for (String s : leftPaths) {  // 拼接上左子树的父结点
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for (String s : rightPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }

        return res;
    }
}
