package _0138_Copy_List_with_Random_Pointer;

/**
 * Date: 2021/1/29 16:28
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了83.85%的用户
 */
public class Solution {

    public Node copyRandomList(Node head) {

        // 复制一个小弟
        for (Node p = head; p != null; p = p.next.next) {
            Node q = new Node(p.val);
            q.next = p.next;
            p.next = q;
        }

        // 复制random指针
        for (Node p = head; p != null; p = p.next.next)
            if (p.random != null)
                p.next.random = p.random.next;

        // 拆分成两个链表
        Node dummy = new Node(-1), cur = dummy;
        for (Node p = head; p != null; p = p.next) {
            Node q = p.next;
            cur.next = q;
            cur = q;
            p.next = q.next;
        }
        return dummy.next;
    }
}
