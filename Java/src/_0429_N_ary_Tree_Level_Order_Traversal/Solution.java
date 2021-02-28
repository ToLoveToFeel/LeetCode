package _0429_N_ary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by WXX on 2021/2/28 18:04
 * 执行用时：4 ms, 在所有 Java 提交中击败了45.55%的用户
 * 内存消耗：39.3 MB, 在所有 Java 提交中击败了70.71%的用户
 */
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> line = new ArrayList<>();
            while (len-- != 0) {
                Node t = q.remove();
                line.add(t.val);
                if (t.children != null)
                    for (Node c : t.children)
                        q.add(c);
            }
            res.add(line);
        }
        return res;
    }
}
