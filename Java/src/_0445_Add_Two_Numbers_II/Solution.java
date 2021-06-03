package _0445_Add_Two_Numbers_II;

/**
 * Date: 2020/10/19 16:09
 * Content:
 * 思路：（1）将两个链表翻转 Leetcode 0206；（2）运用 Leetcode 0002 进行相加；（3）将结果翻转
 */
public class Solution {
    // Leetcode 0206 翻转链表
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rhead;
    }
    // Leetcode 0002 两数之和
    private ListNode addTwoReverseOrderNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        ListNode dummy = new ListNode(0), p = dummy;
        int t = 0;

        while ((cur1 != null) || (cur2 != null)) {
            // 解决链表长度不一致的问题
            if (cur1 != null) { t += cur1.val; cur1 = cur1.next; }
            if (cur2 != null) { t += cur2.val; cur2 = cur2.next; }
            p.next = new ListNode(t % 10);
            t /= 10;
            p = p.next;
        }
        // 解决，两个链表都结束，但最高位（进位）不为0的问题
        if (t != 0) p.next = new ListNode(t);

        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 第一步：将两个链表翻转 Leetcode 0206
        l1 = reverseList(l1); l2 = reverseList(l2);
        // 第二步：相加 Leetcode 0002
        ListNode l = addTwoReverseOrderNumbers(l1, l2);
        // 第三步：将结果翻转并返回
        return reverseList(l);
    }

    public static void main(String[] args) {

		// 创建链表，获取链表头结点
        ListNode l1 = (new MyLinkedList(new int[]{7, 2, 4, 3})).getHead();
        ListNode l2 = (new MyLinkedList(new int[]{5, 6, 4})).getHead();
        ListNode l = (new Solution()).addTwoNumbers(l1, l2);
        MyLinkedList.printLinkedList(l);
    }
}
