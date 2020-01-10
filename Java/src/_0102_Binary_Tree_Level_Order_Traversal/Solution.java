package _0102_Binary_Tree_Level_Order_Traversal;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if (null == root)
            return res;

        LinkedList<Pair<TreeNode, Integer>> q = new LinkedList<>();  // q作为队列
        q.addLast(new Pair<>(root, 0));
        while (!q.isEmpty()){
            Pair<TreeNode, Integer> front = q.removeFirst();
            TreeNode node = front.getKey();
            Integer level = front.getValue();

            if (level == res.size())
                res.add(new ArrayList<>());

            res.get(level).add(node.val);
            if (null != node.left)
                q.addLast(new Pair<>(node.left, level+1));
            if (null != node.right)
                q.addLast(new Pair<>(node.right, level+1));
        }

        return res;
    }
}
