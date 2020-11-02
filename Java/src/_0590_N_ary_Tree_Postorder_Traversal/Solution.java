package _0590_N_ary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/11/2 8:41
 * Content:
 * 递归
 * 执行用时：1 ms, 在所有 Java 提交中击败了96.32%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了56.65%的用户
 */
public class Solution {

    private void dfs(Node node, List<Integer> res) {
        if (node != null) {
            if (node.children != null) {
                for (Node child : node.children) {
                    dfs(child, res);
                }
            }
            res.add(node.val);
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public static void main(String[] args) {
        /*
                    1
                /   |   \
               3    2    4
             /  \
            5   6
         */
        // 第三层
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        // 第二层
        List<Node> list3 = new ArrayList<>();
        list3.add(node5);
        list3.add(node6);
        Node node3 = new Node(3, list3);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        // 第一层
        List<Node> list1 = new ArrayList<>();
        list1.add(node3);
        list1.add(node2);
        list1.add(node4);
        Node root = new Node(1, list1);
        // 测试
        System.out.println((new Solution()).postorder(root));  // 5, 6, 3, 2, 4, 1
    }
}
