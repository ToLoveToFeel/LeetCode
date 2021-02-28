package _0145_Binary_Tree_Postorder_Traversal;

import java.util.*;

/**
 * 非递归算法
 * 执行用时：1 ms, 在所有 Java 提交中击败了53.31%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了54.95%的用户
 */
public class Solution5 {
    // 思路：后序遍历是：左右根，反过来就是：根右左； 按照根右左遍历后，结果再翻转一下即可
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (null != root || !stk.isEmpty()) {
            while (null != root) {
                res.add(root.val);
                stk.push(root);
                root = root.right;
            }
            root = stk.pop().left;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                nu, 2,
                nu, nu, 3
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println((new Solution5()).postorderTraversal(root));
    }
}
