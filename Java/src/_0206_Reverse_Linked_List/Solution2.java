package _0206_Reverse_Linked_List;

public class Solution2 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)

    // 返回以head为头结点的链表反转后的链表头指针
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode rhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rhead;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        // 创建链表
        MyLinkedList myLinkedList = new MyLinkedList(nums);
        ListNode head = myLinkedList.getHead();
        myLinkedList.printLinkedList(head);
        // 翻转链表
        head = (new Solution2()).reverseList(head);
        // 输出链表
        myLinkedList.printLinkedList(head);
    }
}
