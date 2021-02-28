package _0589_N_ary_Tree_Preorder_Traversal;

import java.util.*;

/**
 * Date: 2020/11/2 9:33
 * Content: 非递归
 * 执行用时：5 ms, 在所有 Java 提交中击败了16.09%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了38.13%的用户
 */
public class Solution2 {

    public List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();
        Deque<Node> stk = new ArrayDeque<>();
        if (root != null) stk.push(root);
        while (!stk.isEmpty()) {
            Node t = stk.pop();
            res.add(t.val);
            if (t.children != null) {
                Collections.reverse(t.children);
                for (Node child : t.children)
                    if (child != null)
                        stk.push(child);
            }
        }
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
        System.out.println((new Solution2()).preorder(root));  // 1, 3, 5, 6, 2, 4
    }
}
