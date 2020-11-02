package _0000_study._algorithm.multitreetraversal.postorder;

import java.util.*;

/**
 * Date: 2020/11/2 8:41
 * Content: Leetcode 590
 * 非递归
 * 后续遍历：子节点1 子节点2 ... 子节点n 根
 * 第一步：根 子节点n ... 子节点2 子节点1
 * 第二步：翻转
 *
 * 执行用时：5 ms, 在所有 Java 提交中击败了22.77%的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了71.00%的用户
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/ncha-shu-de-hou-xu-bian-li-by-leetcode/
 */
public class Postorder {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    if (child != null)
                        stack.push(child);
                }
            }
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
        System.out.println((new Postorder()).postorder(root));  // 5, 6, 3, 2, 4, 1
    }
}
