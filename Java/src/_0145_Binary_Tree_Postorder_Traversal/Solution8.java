package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution8 {
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        while(cur != null || !stack.empty()){

            if(cur != null){  // 将Solution7的while替换为if即可
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                if(cur.right == null || pre == cur.right){
                    res.add(cur.val);
                    pre = cur;
                    cur = null;
                }
                else{
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
