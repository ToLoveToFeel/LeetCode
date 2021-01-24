package _0203_Remove_Linked_List_Elements;

public class Solution4 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        // 创建链表
        MyLinkedList myLinkedList = new MyLinkedList(nums);
        ListNode head = myLinkedList.getHead();
        System.out.println(myLinkedList);
        // 删除元素
        (new Solution4()).removeElements(head, 6);
        // 输出链表
        System.out.println(myLinkedList);
    }
}
