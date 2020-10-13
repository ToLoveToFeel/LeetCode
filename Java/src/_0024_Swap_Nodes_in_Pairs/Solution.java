package _0024_Swap_Nodes_in_Pairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // 创建链表，获取链表头结点
        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4})).getHead();
        MyLinkedList.printLinkedList(head);

        head = (new Solution()).swapPairs(head);
        MyLinkedList.printLinkedList(head);
    }
}
