package _0061_Rotate_List;

/**
 * 链表遍历了两次
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null) return head;

        int count = 0;  // 存储链表元素个数
        ListNode curNode = head;
        while (null != curNode) {
            count++;
            curNode = curNode.next;
        }

        k = k % count;
        // 移动次数是链表元素的整数倍，不需要旋转
        if (k == 0) return head;

        //  否则，需要旋转，双指针
        ListNode p = head, q = head;
        for (int i = 0; i < k; i++) q = q.next;

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        ListNode res = p.next;
        p.next = null;
        q.next = head;

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = new ListNode(arr);
        System.out.println(head);
        head = (new Solution()).rotateRight(head, k);
        System.out.println(head);
    }
}
