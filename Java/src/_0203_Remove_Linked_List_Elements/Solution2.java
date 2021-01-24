package _0203_Remove_Linked_List_Elements;

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) head = head.next;
        if (head == null) return head;

        ListNode preNode = head;
        while (preNode.next != null) {
            if (preNode.next.val == val) preNode.next = preNode.next.next;
            else preNode = preNode.next;
        }
        return head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        // 创建链表
        MyLinkedList myLinkedList = new MyLinkedList(nums);
        ListNode head = myLinkedList.getHead();
        System.out.println(myLinkedList);
        // 删除元素
        head = (new Solution2()).removeElements(head, 6);
        // 输出链表
        MyLinkedList.printLinkedList(head);
    }
}
