package _0019_Remove_Nth_Node_From_End_of_List;

public class Solution2 {
    // 时间复杂度：O(n)
    // 链表遍历了一次
    // 空间复杂度：O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n must grater then 0!");
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++)
            q = q.next;

        while (null != q){
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 5;
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution()).removeNthFromEnd(head, n);
        System.out.println(head);
    }
}
