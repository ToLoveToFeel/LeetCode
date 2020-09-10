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
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    public final int capacity;
    private DLinkedNode dummyHead, dummyTail;  // 虚拟头结点、虚拟尾节点，头部节点为最新使用过的数据

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dummyHead = new DLinkedNode();
        dummyTail = new DLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.next = dummyHead;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null)
            return -1;
        // 如果key存在，将该数据更新到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {  // key不存在，创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);  // 添加进哈希表
            addToHead(newNode);  // 添加至双向链表的头结点
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();  // 如果超出容量，删除双向链表的尾部节点
                cache.remove(tail.key);  // 删除哈希表中对应的项
                size--;
            }
        } else {  // 如果key存在，更新value，并将节点移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {  // 双向链表在头部添加节点
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void removeNode(DLinkedNode node) {  // 双向链表删除node节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {  // 将node节点移到头结点
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = dummyTail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
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
