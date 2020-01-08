package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution4 {
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
        Stack<Integer> output = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();  // （根）
            output.push(curNode.val);

            if (null != curNode.left)  // 先入左结点，后入右结点，出栈的顺序就是：（右左）
                stack.push(curNode.left);
            if (null != curNode.right)
                stack.push(curNode.right);
        }

        while (!output.isEmpty())
            res.add(output.pop());

        return res;
    }
}
