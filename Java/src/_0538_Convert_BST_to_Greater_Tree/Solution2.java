package _0538_Convert_BST_to_Greater_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/9/21 8:14
 * Content:
 * BST 中序遍历 是 有序的
 * 反向中序遍历：左根右 --> 右根左
 */
public class Solution2 {

    int sum = 0;

    // 将以 root 为根的 BST 转为累加树
    public TreeNode convertBST(TreeNode root) {

        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.right;
            }

            cur = stk.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }

        return root;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                5,
                3, 13,
                nu, 4, 7, 16
        };
        TreeNode root = new MyTree(nums).getRoot();

        (new Solution2()).convertBST(root);
        System.out.println(MyTree.levelOrder(root));
    }
}
