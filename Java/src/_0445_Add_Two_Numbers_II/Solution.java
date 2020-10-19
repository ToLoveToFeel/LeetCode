package _0445_Add_Two_Numbers_II;

/**
 * Date: 2020/10/19 16:09
 * Content:
 * 思路：（1）将两个链表翻转 Leetcode 0206；（2）运用 Leetcode 0002 进行相加；（3）将结果翻转
 */
public class Solution {
    // Leetcode 0206 翻转链表
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode rhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rhead;
    }

    // Leetcode 0002 两数之和
	private ListNode addTwoReverseOrderNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int temp = 0;

        while ((cur1 != null) || (cur2 != null)) {
            // 解决链表长度不一致的问题
            int num1 = (cur1 == null ? 0 : cur1.val);
            int num2 = (cur2 == null ? 0 : cur2.val);
            p.next = new ListNode((num1 + num2 + temp) % 10);
            temp = (num1 + num2 + temp) / 10;
            cur1 = (cur1 != null ? cur1.next : null);
            cur2 = (cur2 != null ? cur2.next : null);
            p = p.next;
        }
        // 解决，两个链表都结束，但最高位（进位）不为0的问题
        if (temp != 0)
            p.next = new ListNode(temp);

        return dummyHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 第一步：将两个链表翻转 Leetcode 0206
        l1 = reverseList(l1);
        l2 = reverseList(l2);

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
