package _0099_Recover_Binary_Search_Tree;

/**
 * Date: 2021/7/16 11:29
 * Content:
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了96.66%的用户
 */
public class Solution {

    public void recoverTree(TreeNode root) {

        TreeNode first = null, second = null, last = null;
        while (root != null) {
            if (root.left == null) {  // (1)
                // 原始Morris遍历中对应输出节点的操作
                if (last != null && last.val > root.val) {
                    if (first == null) {
                        first = last;
                        second = root;
                    } else second = root;
                }
                last = root;

                root = root.right;
            } else {  // (2)
                TreeNode p = root.left;
                while (p.right != null && p.right != root) p = p.right;

                if (p.right == null) {  // (2.1)
                    p.right = root;
                    root = root.left;
                } else {  // (2.2)
                    p.right = null;

                    // 原始Morris遍历中对应输出节点的操作
                    if (last != null && last.val > root.val) {
                        if (first == null) {
                            first = last;
                            second = root;
                        } else second = root;
                    }
                    last = root;

                    root = root.right;
                }
            }
        }
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = {
                3,
                1, 4,
                nu, nu, 2
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        new Solution().recoverTree(root);
        System.out.println(MyTree.levelOrder(root));  // [[2], [1, 4], [3]]
    }
}
