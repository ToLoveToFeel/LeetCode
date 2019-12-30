package _0203_Remove_Linked_List_Elements;

public class Solution4 {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head)
            return null;
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode ret = (new Solution4()).removeElements(head,6);
        System.out.println(ret);
    }
}
