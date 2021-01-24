package _0148_Sort_List;

/**
 * Date: 2020/11/21 10:33
 * Content: 使用归并排序解决
 * 执行用时：12 ms, 在所有 Java 提交中击败了18.08%的用户
 * 内存消耗：45 MB, 在所有 Java 提交中击败了27.00%的用户
 */
public class Solution {

    // Leetcode 0021 合并两个有序链表
    // 返回l1和l2合并后链表的头结点
    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        else if (l1.val < l2.val) { // 递归
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public ListNode sortList(ListNode head) {
        // 递归到底情况处理，链表为空，或者链表只有一个节点
        if (head == null || head.next == null)
            return head;

        // 快慢指针，寻找中间点
        ListNode s = head, f = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode newHead = s.next;
        s.next = null;  // 断开链表，分成前后两部分

        ListNode left = sortList(head);
        ListNode right = sortList(newHead);

        return merge(left, right);  // 返回合并后的链表头指针
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
        ListNode head = (new MyLinkedList(new int[]{4, 2, 1, 3})).getHead();
        head = (new Solution()).sortList(head);
        MyLinkedList.printLinkedList(head);
    }
}
