package _0590_N_ary_Tree_Postorder_Traversal;

import java.util.*;

/**
 * Date: 2020/11/2 8:41
 * Content: 非递归
 * 后续遍历：子节点1 子节点2 ... 子节点n 根
 * 第一步：根 子节点n ... 子节点2 子节点1
 * 第二步：翻转得到结果
 * 执行用时：4 ms, 在所有 Java 提交中击败了40.11%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了47.68%的用户
 */
public class Solution2 {

    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();
        Deque<Node> stk = new ArrayDeque<>();
        if (root != null) stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            res.add(node.val);
            if (node.children != null)
                for (Node child : node.children)
                    if (child != null)
                        stk.push(child);
        }
        Collections.reverse(res);
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
        System.out.println((new Solution2()).postorder(root));  // 5, 6, 3, 2, 4, 1
    }
}
