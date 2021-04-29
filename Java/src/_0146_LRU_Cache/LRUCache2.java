package _0146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020/9/9 21:45
 * Content:
 * 模仿LinkedHashMap
 * 时间复杂度：O(1)   put和get都是O(1)的复杂度
 * 空间复杂度:O(n)
 */
public class LRUCache2 {

    static class Node {
        int key, val;
        Node left, right;
        public Node(int _key, int _val) {
            key = _key; val = _val; left = null; right = null;
        }
    }

    Node L = new Node(-1, -1), R = new Node(-1, -1);
    HashMap<Integer, Node> hash = new HashMap<>();
    int n;

    public LRUCache2(int capacity) {
        n = capacity;
        L.right = R; R.left = L;
    }

    public int get(int key) {
        if (!hash.containsKey(key)) return -1;
        else {
            Node p = hash.get(key);
            remove(p);
            insert(p);
            return p.val;
        }
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            Node p = hash.get(key);
            p.val = value;
            remove(p);
            insert(p);
        } else {
            if (hash.size() == n) {
                Node p = R.left;
                remove(p);
                hash.remove(p.key);
                p = null;  // help GC
            }
            Node p = new Node(key, value);
            hash.put(key, p);
            insert(p);
        }
    }

    // 辅助函数
    private void remove(Node p) {
        p.left.right = p.right;
        p.right.left = p.left;
    }

    private void insert(Node p) {
        p.right = L.right;
        p.left = L;
        L.right.left = p;
        L.right = p;
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 0);
        cache.put(2, 2);
        System.out.println(cache.get(1));  // 返回  1
        cache.put(3, 3);  // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));  // 返回 -1 (未找到)
        cache.put(4, 4);  // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));  // 返回 -1 (未找到)
        System.out.println(cache.get(3));  // 返回  3
        System.out.println(cache.get(4));  // 返回  4
    }
}
