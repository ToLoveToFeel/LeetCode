package _0094_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * // InOrder Morris Traversal
 * // 参考网址：https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 * // 时间复杂度：O(n)，n为节点数目
 * // 空间复杂度：O(1)
 * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
 * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
 * a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。输出当前节点，当前节点更新为当前节点的左孩子。
 * b) 如果前驱节点的右孩子为当前节点，将它（前驱节点）的右孩子重新设为空。当前节点更新为当前节点的右孩子。
 * 3. 重复以上1、2直到当前节点为空。
 */

public class Solution6 {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        TreeNode cur = root;
        while (cur != null) {

            if (cur.left == null) {  // 1.
                res.add(cur.val);
                cur = cur.right;
            } else {
                // find predecessor
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null) {  // 2.a
                    prev.right = cur;
                    cur = cur.left;
                } else {                    // 2.b
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
