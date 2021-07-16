package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Morris
 * 参考网址：https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了29.44%的用户
 */
public class Solution10 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.right == null) {  // (1)
                res.add(root.val);
                root = root.left;
            } else {  // (2)
                TreeNode p = root.right;
                while (p.left != null && p.left != root) p = p.left;

                if (p.left == null) {  // (2.1)
                    p.left = root;
                    res.add(root.val);
                    root = root.right;
                } else {  // (2.2)
                    p.left = null;
                    root = root.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}
