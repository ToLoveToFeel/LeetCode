package _0019_Remove_Nth_Node_From_End_of_List;

/**
 * 链表遍历了一次
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead, q = dummyHead;
        for (int i = 0; i < n + 1; i++) q = q.next;

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {

        int n = 2;
        // 创建链表，获取链表头结点
        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4, 5})).getHead();
        head = (new Solution2()).removeNthFromEnd(head, n);
        MyLinkedList.printLinkedList(head);
    }
}
