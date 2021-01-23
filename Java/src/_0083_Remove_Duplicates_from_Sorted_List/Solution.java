package _0083_Remove_Duplicates_from_Sorted_List;

/**
 * Date: 2020/10/2 10:20
 * Content:
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ListNode p = head, q = head.next;
        while (q != null) {
            if (p.val == q.val) p.next = q.next;
            else p = q;
            q = q.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head = (new MyLinkedList(new int[]{1, 1, 2, 3, 3})).getHead();
        head = (new Solution()).deleteDuplicates(head);
        MyLinkedList.printLinkedList(head);
    }
}
