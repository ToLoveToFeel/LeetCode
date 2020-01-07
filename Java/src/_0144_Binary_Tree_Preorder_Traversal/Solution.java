package _0144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 递归算法
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        preorderTraversal(root, res);

        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list){
        if (null != node){
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }

    public static void main(String[] args) {

    }
}
