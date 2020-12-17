package _0653_Two_Sum_IV_Input_is_a_BST;

import java.util.HashSet;

/**
 * Date: 2020/12/17 15:34
 * Content: 中序遍历+哈希表
 * 执行用时：3 ms, 在所有 Java 提交中击败了97.76%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了77.93%的用户
 */
public class Solution {

    HashSet<Integer> set;

    public boolean findTarget(TreeNode root, int k) {

        set = new HashSet<>();
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k) {

        if (root == null)
            return false;

        if (dfs(root.left, k))
            return true;

        int x = root.val;
        if (set.contains(k - x))
            return true;
        set.add(x);

        return dfs(root.right, k);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                5, 6,
                2, 4, nu, 7
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution()).findTarget(root, 9));
    }
}
