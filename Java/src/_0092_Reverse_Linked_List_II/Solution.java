package _0092_Reverse_Linked_List_II;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.1 MB, 在所有 Java 提交中击败了33.86%的用户
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode a = dummy;
        for (int i = 0; i < m - 1; i++) a = a.next;
        ListNode b = a.next, c = b.next;
        for (int i = 0; i < n - m; i++) {
            ListNode t = c.next;
            c.next = b;
            b = c;
            c = t;
        }
        a.next.next = c;
        a.next = b;

        return dummy.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        // 创建链表，获取链表头结点
        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4, 5})).getHead();
        // 翻转链表
        head = solution.reverseBetween(head, 2, 4);
        // 输出链表
        MyLinkedList.printLinkedList(head);
    }
}
