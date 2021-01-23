package _0024_Swap_Nodes_in_Pairs;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36 MB, 在所有 Java 提交中击败了60.91%的用户
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = p.next.next.next;

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
