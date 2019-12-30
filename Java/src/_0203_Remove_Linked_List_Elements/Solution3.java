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
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode ret = (new Solution3()).removeElements(head,6);
        System.out.println(ret);
    }
}
