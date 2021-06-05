package _0460_LFU_Cache;

import java.util.HashMap;

/**
 * Date: 2021/6/5 19:58
 */
public class Solution {

    static class LFUCache {

        // Block中都是Node, 相当于LC146中的Node
        static class Node {
            Node left, right;
            int key, val;
            public Node(int _key, int _val) {
                key = _key; val = _val;
                left = right = null;
            }
        };

        // 相当于LC432中的Node
        static class Block {
            Block left, right;
            Node head, tail;
            int cnt;  // Block中对应的Node被访问了cnt次

            public Block(int _cnt) {
                cnt = _cnt;
                left = right = null;
                head = new Node(-1, -1); tail = new Node(-1, -1);  // 哨兵
                head.right = tail; tail.left = head;
            }

            // 在该Block中的head后插入p
            void insert(Node p) {
                p.right = head.right;
                p.left = head;
                head.right.left = p;
                head.right = p;
            }

            // 在该Block中删除p
            void remove(Node p) {
                p.left.right = p.right;
                p.right.left = p.left;
            }

            boolean empty() {
                return head.right == tail;
            }
        }

        Block head, tail;

        int n;  // 最大容量
        HashMap<Integer, Block> hash_block = new HashMap<>();
        HashMap<Integer, Node> hash_node = new HashMap<>();

        private void insert(Block p) {  // 在p的右侧插入新块，cnt是p.cnt + 1
            Block cur = new Block(p.cnt + 1);
            cur.left = p;
            cur.right = p.right;
            p.right.left = cur;
            p.right = cur;
        }

        private void remove(Block p) {
            p.right.left = p.left;
            p.left.right = p.right;
            p = null;  // help GC
        }

        public LFUCache(int capacity) {
            n = capacity;
            head = new Block(0); tail = new Block(Integer.MAX_VALUE);
            head.right = tail; tail.left = head;
        }

        public int get(int key) {
            if (!hash_block.containsKey(key)) return -1;
            Block block = hash_block.get(key);
            Node node = hash_node.get(key);
            // 将node放到cnt等于block.cnt+1对应Block中
            block.remove(node);
            if (block.right.cnt != block.cnt + 1) insert(block);  // 不存在则创建
            block.right.insert(node);
            hash_block.put(key, block.right);
            if (block.empty()) remove(block);  // Block中没有数据就应该删除,这样head.right一定是访问次数最少的Block
            return node.val;
        }

        public void put(int key, int value) {
            if (n == 0) return;
            if (hash_block.containsKey(key)) {
                hash_node.get(key).val = value;
                get(key);  // 相当于让key对应的访问次数加一
            } else {
                if (hash_block.size() == n) {  // 移除访问次数最少且最久未使用的Node
                    Node p = head.right.tail.left;
                    head.right.remove(p);
                    if (head.right.empty()) remove(head.right);
                    hash_block.remove(p.key);
                    hash_node.remove(p.key);
                    p = null;
                }
                Node p = new Node(key, value);
                if (head.right.cnt > 1) insert(head);
                head.right.insert(p);
                hash_block.put(key, head.right);
                hash_node.put(key, p);
            }
        }
    }

    public static void main(String[] args) {

        LFUCache t = new LFUCache(2);
        t.put(1, 1);
        t.put(2, 2);
        System.out.println(t.get(1));  // 1
        t.put(3, 3);
        System.out.println(t.get(2));  // -1
        System.out.println(t.get(3));  // 3
        t.put(4, 4);
        System.out.println(t.get(1));  // -1
        System.out.println(t.get(3));  // 3
        System.out.println(t.get(4));  // 4
    }
}
