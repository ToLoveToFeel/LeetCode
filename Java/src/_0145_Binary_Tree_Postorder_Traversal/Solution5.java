package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution5 {
    // 非递归算法
    // 时间复杂度：O(n)，n为节点数目
    // 空间复杂度：O(n)
    /*
        思路：后序遍历是：左右根，反过来就是：根右左； 按照根右左遍历后，再反过来
     */
    public List<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        TreeNode curNode = root;

        while (null != curNode || !stack.empty()){
            while (null != curNode){
                output.push(curNode);
                stack.push(curNode);
                curNode = curNode.right;
            }

            curNode = stack.pop();
            curNode = curNode.left;
        }
        while (!output.isEmpty())
            res.add(output.pop().val);
        return res;
    }
}
