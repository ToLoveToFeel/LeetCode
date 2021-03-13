package _0025_Reverse_Nodes_in_k_Group;

/**
 * Created by WXX on 2021/3/13 21:17
 * 执行用时：1 ms, 在所有 Java 提交中击败了34.72%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了79.55%的用户
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode p = dummy; ; ) {
            ListNode q = p;
            for (int i = 0; i < k && q != null; i++) q = q.next;
            if (q == null) break;
            ListNode a = p.next, b = a.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode c = b.next;
                b.next = a;
                a = b;
                b = c;
            }
            ListNode c = p.next;
            p.next = a;
            c.next = b;
            p = c;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4, 5})).getHead();
        MyLinkedList.printLinkedList((new Solution()).reverseKGroup(head, 2));
    }
}
