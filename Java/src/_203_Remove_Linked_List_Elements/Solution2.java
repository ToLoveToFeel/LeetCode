package _203_Remove_Linked_List_Elements;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        if(null == head)
            return head;

        ListNode preNode = head;
        while(preNode.next != null) {
            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            } else {
                preNode = preNode.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode ret = (new Solution2()).removeElements(head,6);
        System.out.println(ret);
    }
}
