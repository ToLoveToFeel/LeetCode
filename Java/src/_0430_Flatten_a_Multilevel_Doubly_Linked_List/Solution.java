package _0430_Flatten_a_Multilevel_Doubly_Linked_List;

/**
 * Date: 2021/6/1 15:11
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了43.16%的用户
 */
public class Solution {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node[] res = dfs(head);
        return res[0];
    }

    Node[] dfs(Node head) {
        if (head == null) return new Node[]{null, null};
        Node cur = head, tail = head;
        while (cur != null) {
            tail = cur;
            if (cur.child != null) {
                Node[] t = dfs(cur.child);
                cur.child = null;
                t[1].next = cur.next;
                if (cur.next != null) cur.next.prev = t[1];
                cur.next = t[0];
                t[0].prev = cur;
                cur = t[1].next;
                tail = t[1];
            } else {
                cur = cur.next;
            }
        }
        return new Node[]{head, tail};
    }
}
