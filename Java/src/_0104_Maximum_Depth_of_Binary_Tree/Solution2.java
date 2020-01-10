package _0104_Maximum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    // 队列
    // BFS
    public int maxDepth(TreeNode root){
        if (null == root)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 记录当前层的数量
        int maxDepth = 0;  // 记录深度

        while (!queue.isEmpty()){
            int newLevelNum = 0;
            maxDepth++;
            for (int i = 0; i < levelNum; i++){
                TreeNode node = queue.remove();

                if (node.left != null){
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            levelNum = newLevelNum;
        }
        return maxDepth;
    }
}
