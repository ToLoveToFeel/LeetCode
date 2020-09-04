package _0203_Remove_Linked_List_Elements;

public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preNode = dummyHead;

        while(preNode.next != null) {
            if (preNode.next.val == val)
                preNode.next = preNode.next.next;
            else
                preNode = preNode.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        // 创建链表
        MyLinkedList myLinkedList = new MyLinkedList(nums);
        ListNode head = myLinkedList.getHead();
        System.out.println(myLinkedList);

        // 删除元素
        ListNode ret = (new Solution3()).removeElements(head,6);
        // 输出链表
        System.out.println(myLinkedList);
    }
}
