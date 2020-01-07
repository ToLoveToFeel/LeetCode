package _0237_Delete_Node_in_a_Linked_List;

public class Solution {
    public void deleteNode(ListNode node) {
        if (null == node || null == node.next)
            throw new IllegalArgumentException("node should be valid and can not be the tail node.");

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 9};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node = head.findNode(5);

        (new Solution()).deleteNode(node);
        System.out.println(head);
    }
}
