package _0328_Odd_Even_Linked_List;

/**
 * Date: 2020/11/13 10:10
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了5.10%的用户
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode oh = head, ot = oh;  // 奇数
        ListNode eh = head.next, et = eh;  // 偶数
        for (ListNode p = head.next.next; p != null; ) {
            ot = ot.next = p;
            p = p.next;
            if (p != null) {
                et = et.next = p;
                p = p.next;
            }
        }
        ot.next = eh;
        et.next = null;
        return oh;
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
//        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4, 5})).getHead();  // 1->3->5->2->4->NULL
        ListNode head = (new MyLinkedList(new int[]{2, 1, 3, 5, 6, 4, 7})).getHead();  // 2->3->6->7->1->5->4->NULL
        head = (new Solution()).oddEvenList(head);

        MyLinkedList.printLinkedList(head);
    }
}
