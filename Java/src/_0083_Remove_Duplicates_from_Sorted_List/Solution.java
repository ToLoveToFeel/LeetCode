package _0083_Remove_Duplicates_from_Sorted_List;

/**
 * Date: 2020/10/2 10:20
 * Content:
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ListNode curNode = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            if (curNode.val == nextNode.val) {
                curNode.next = nextNode.next;
            } else {
                curNode = nextNode;
            }
            nextNode = nextNode.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head = (new MyLinkedList(new int[]{1, 1, 2, 3, 3})).getHead();
        head = (new Solution()).deleteDuplicates(head);
        MyLinkedList.printLinkedList(head);
    }
}
