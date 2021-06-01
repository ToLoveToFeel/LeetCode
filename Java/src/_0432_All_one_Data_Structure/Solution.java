package _0432_All_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Date: 2021/6/1 19:15
 */
public class Solution {

    static class AllOne {

        static class Node {
            Node left, right;
            int val;
            HashSet<String> S;

            public Node (int _val) {
                val = _val;
                left = right = null;
                S = new HashSet<>();
            }
        }
        Node head, tail;
        HashMap<String, Node> hash = new HashMap<>();

        /** Initialize your data structure here. */
        public AllOne() {
            head = new Node(Integer.MIN_VALUE); tail = new Node(Integer.MAX_VALUE);
            head.right = tail; tail.left = head;
        }

        // 辅助函数：在node右侧插入值为val的节点，如果右侧存在值为val的节点，则将key插入对应节点中的集合中
        private Node add_to_right(Node node, String key, int val) {
            if (node.right.val == val) node.right.S.add(key);
            else {
                // 在node和node.right中间插入一个节点t
                Node t = new Node(val);
                t.S.add(key);
                t.right = node.right; node.right.left = t;
                t.left = node; node.right = t;
            }
            return node.right;
        }

        // 辅助函数：在node左侧插入值为val的节点，如果左侧存在值为val的节点，则将key插入对应节点中的集合中
        private Node add_to_left(Node node, String key, int val) {
            if (node.left.val == val) node.left.S.add(key);
            else {
                // 在node和node->right中间插入一个节点t
                Node t = new Node(val);
                t.S.add(key);
                t.left = node.left; node.left.right = t;
                t.right = node; node.left = t;
            }
            return node.left;
        }

        // 辅助函数：删除节点node
        private void remove(Node node) {
            node.left.right = node.right;
            node.right.left = node.left;
            node = null;
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if (!hash.containsKey(key)) hash.put(key, add_to_right(head, key, 1));
            else {
                Node t = hash.get(key);
                t.S.remove(key);
                hash.put(key, add_to_right(t, key, t.val + 1));
                if (t.S.isEmpty()) remove(t);  // 节点没有任何字符串的需要删除该节点
            }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if (!hash.containsKey(key)) return;
            Node t = hash.get(key);
            t.S.remove(key);
            if (t.val > 1) {
                hash.put(key, add_to_left(t, key, t.val - 1));
            } else {
                hash.remove(key);
            }
            if (t.S.isEmpty()) remove(t);
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if (tail.left != head) return tail.left.S.iterator().next();
            return "";
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if (head.right != tail) return head.right.S.iterator().next();
            return "";
        }
    }

    public static void main(String[] args) {

        AllOne t = new AllOne();
        t.inc("hello");
        t.inc("world");
        t.inc("world");
        System.out.println(t.getMaxKey());  // world
        t.dec("world");
        t.dec("world");
        System.out.println(t.getMaxKey());  // hello
        System.out.println(t.getMinKey());  // hello
    }
}
