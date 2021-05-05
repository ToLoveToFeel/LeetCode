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

        if (root == null) return new ArrayList<>();  // 空节点
        if (root.left == null && root.right == null)  // 叶节点
            return new ArrayList<String>(){{add(root.val + "");}};

        List<String> res = new ArrayList<>();
        List<String> left = binaryTreePaths(root.left), right = binaryTreePaths(root.right);
        for (String s : left) res.add(root.val + "->" + s);
        for (String s : right) res.add(root.val + "->" + s);
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
