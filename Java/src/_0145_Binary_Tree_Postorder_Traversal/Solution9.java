package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * PostOrder Morris Traversal
 * 参考网址：https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 * 时间复杂度：O(n)，n为节点数目
 * 空间复杂度：O(1)
 */
public class Solution9 {

    /*
        1. 如果当前节点的左孩子为空，则将其右孩子作为当前节点。
        2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
            a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
            b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。倒序输出从当前节点的左孩子到
            该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右孩子。
        3. 重复以上1、2直到当前节点为空。
    */
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        TreeNode dummyRoot = new TreeNode(-1);
        dummyRoot.left = root;

        TreeNode cur = dummyRoot;
        while (cur != null) {
            if (cur.left == null)
                cur = cur.right;
            else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    reverseTraversal(cur.left, res);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    private void reverseTraversal(TreeNode node, ArrayList<Integer> res) {
        int start = res.size();
        while (node != null) {
            res.add(node.val);
            node = node.right;
        }

        int i = start, j = res.size() - 1;
        while (i < j) {
            Integer t = res.get(i);
            res.set(i, res.get(j));
            res.set(j, t);

            i++;
            j--;
        }
    }
}
