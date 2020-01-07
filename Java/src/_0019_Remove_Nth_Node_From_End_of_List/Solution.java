package _0019_Remove_Nth_Node_From_End_of_List;

public class Solution {
    // 时间复杂度：O(n)
    // 链表遍历了两次
    // 空间复杂度：O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;  // 存储链表元素个数
        int delNum = 0;  // 存储正数要删除的元素位置，head位置为1

        ListNode curNode = head;
        while (curNode != null){
            count ++;
            curNode = curNode.next;
        }

        delNum = count - n + 1;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        for (int i = 0; i < delNum - 1; i++)
            p = p.next;

        // p后面的元素需要删除
        p.next = p.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 1;
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution()).removeNthFromEnd(head, n);
        System.out.println(head);
    }
}
