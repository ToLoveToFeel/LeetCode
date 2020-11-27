package _0129_Sum_Root_to_Leaf_Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/4 21:11
 * Content:
 */
public class Solution2 {

    // 返回node为根节点，num为数据最高位的所有数据之和。比如 num = 12，那么所有的以node为根节点形成的数据最高位都要加12
    private int dfs(TreeNode node, int num) {

        if (node == null)
            return 0;

        int res = num * 10 + node.val;  // 每深入一层，上一层的数就要乘10
        if (node.left == null && node.right == null)
            return res;
        return dfs(node.left, res) + dfs(node.right, res);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                4,
                9, 0,
                5, 1
        };

        // 生成二叉树
        MyTree myTree = new MyTree(nums);
        TreeNode root = myTree.getRoot();
        // 计算
        System.out.println((new Solution2()).sumNumbers(root));
    }
}
