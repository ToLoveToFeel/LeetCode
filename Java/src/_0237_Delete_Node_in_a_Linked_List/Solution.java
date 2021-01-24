package _0237_Delete_Node_in_a_Linked_List;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了41.40%的用户
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
        ListNode head = (new MyLinkedList(new int[]{4, 5, 1, 9})).getHead();
        MyLinkedList.printLinkedList(head);
        ListNode d = head.next.next;  // 1
        (new Solution()).deleteNode(d);
        MyLinkedList.printLinkedList(head);
    }
}
