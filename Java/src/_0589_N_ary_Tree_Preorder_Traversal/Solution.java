package _0589_N_ary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/11/2 9:33
 * Content:
 * 递归
 * 执行用时：1 ms, 在所有 Java 提交中击败了95.48%的用户
 * 内存消耗：39.6 MB, 在所有 Java 提交中击败了56.39%的用户
 */
public class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null) return;
        res.add(root.val);
        if (root.children != null)
            for (Node child : root.children)
                dfs(child);
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
        System.out.println((new Solution()).preorder(root));  // 1, 3, 5, 6, 2, 4
    }
}
