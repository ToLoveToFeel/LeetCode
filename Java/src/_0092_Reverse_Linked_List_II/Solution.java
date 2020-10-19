package _0092_Reverse_Linked_List_II;

public class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode left = new ListNode(0);  // 第 n+1 个结点

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        for (int i = 0; i < m - 1; i++, pre = pre.next) ;

        ListNode tail = pre.next;  // 翻转后链表的结尾

        // 将反转后的链表接入原本链表中
        pre.next = reverse(pre.next, n - m);
        tail.next = left;

        return dummyHead.next;
    }

    // 返回反转后链表头指针
    private ListNode reverse(ListNode head, int index) {
        if (index == 0) {
            left = head.next;
            return head;
        }

        ListNode ret = reverse(head.next, index - 1);
        head.next.next = head;

        return ret;
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
