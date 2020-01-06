package _0024_Swap_Nodes_in_Pairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (null != p.next && null != p.next.next){
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
        int[] nums = {1, 2, 3 ,4};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode ret = (new Solution()).swapPairs(head);

        System.out.println(ret);
    }
}
