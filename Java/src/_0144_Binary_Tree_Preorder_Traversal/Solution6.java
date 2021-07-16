package _0144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Morris
 * 参考网址：https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了46.51%的用户
 */
public class Solution6 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {  // (1)
                res.add(root.val);
                root = root.right;
            } else {  // (2)
                TreeNode p = root.left;
                while (p.right != null && p.right != root) p = p.right;

                if (p.right == null) {  // (2.1)
                    p.right = root;
                    res.add(root.val);
                    root = root.left;
                } else {  // (2.2)
                    p.right = null;
                    root = root.right;
                }
            }
        }
        return res;
    }
}
