package _0102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root){
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (null == root)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 当前层的节点数

        while (!queue.isEmpty()){
            int newLevelNum = 0;
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelNum; i++){  // 遍历当前层的所有节点
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            res.add(level);
            levelNum = newLevelNum;
        }
        return res;
    }
}
