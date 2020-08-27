package _0002_Add_Two_Numbers;

/**
 * Date: 2020/8/27 10:08
 * Content:
 * 时间复杂度：O(\max(m, n))O(max(m,n))，假设 mm 和 nn 分别表示 l1l1 和 l2l2 的长度，上面的算法最多重复 \max(m, n)max(m,n) 次。
 * 空间复杂度：O(\max(m, n))O(max(m,n))， 新列表的长度最多为 \max(m,n) + 1max(m,n)+1。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
}
