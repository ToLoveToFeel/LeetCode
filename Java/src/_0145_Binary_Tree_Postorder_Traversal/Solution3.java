package _0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    // 非递归算法
    // 时间复杂度：O(n)，n为节点数目
    // 空间复杂度：O(h)，h为二叉树高度
    private class TagNode{
        TreeNode node;
        boolean isFirst;
        TagNode(TreeNode node){
            this.node = node;
            this.isFirst = false;
        }
    };

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TagNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){

            while(cur != null){
                stack.push(new TagNode(cur));
                cur = cur.left;
            }

            TagNode tagNode = stack.pop();
            cur = tagNode.node;
            if(tagNode.isFirst == false){
                tagNode.isFirst = true;
                stack.push(tagNode);
                cur = cur.right;
            }
            else{
                res.add(cur.val);
                cur = null;
            }
        }
        return res;
    }
}
