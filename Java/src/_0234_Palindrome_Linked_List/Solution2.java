package _0234_Palindrome_Linked_List;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/23 10:13
 * Content:
 * 将后一半链表翻转，然后对比
 */
public class Solution2 {

    private ListNode reverseList(ListNode node) {

        if (node == null || node.next == null)
            return node;

        ListNode rhead = reverseList(node.next);
        node.next.next = node;
        node.next = null;

        return rhead;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        // 第一步：将链表一分为二：利用快慢指针，如果偶数个节点，则前后均分；如果奇数个节点，前面的会多一个 Leetcode 143
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;

        // 第二步：将后一个链表翻转，后一个链表的头结点为 newHead，链表翻转可以参考 Leetcode 0206
        newHead = reverseList(newHead);

        // 第三步：对比两个链表
        ListNode p1 = head, p2 = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
//        ListNode head = (new MyLinkedList(new int[]{1, 2})).getHead();  // false
        ListNode head = (new MyLinkedList(new int[]{1, 2, 2, 1})).getHead();  // true
        System.out.println((new Solution2()).isPalindrome(head));
    }
}
