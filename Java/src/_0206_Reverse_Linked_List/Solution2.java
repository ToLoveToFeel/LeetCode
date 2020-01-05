package _0206_Reverse_Linked_List;

public class Solution2 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 返回以head为头结点的链表反转后的链表头指针
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode rhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rhead;
    }
}
