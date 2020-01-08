package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution6 {
    // 非递归算法
    // 时间复杂度：O(n)，n为节点数目
    // 空间复杂度：O(h)
    // 用pre记录上次访问的结点
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        stack.push(root);
        while(!stack.empty()){

            TreeNode cur = stack.pop();
            if((cur.left == null && cur.right == null) ||
                    (pre != null && pre == cur.left && cur.right == null) ||
                    (pre != null && pre == cur.right)){
                res.add(cur.val);
                pre = cur;
            }
            else{
                stack.push(cur);
                if(cur.right != null)
                    stack.push(cur.right);
                if(cur.left != null)
                    stack.push(cur.left);
            }
        }
        return res;
    }
}
