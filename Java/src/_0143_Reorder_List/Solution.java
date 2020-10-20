package _0143_Reorder_List;

/**
 * Date: 2020/10/9 10:10
 * Content:
 * 思路：将链表一分为二，后面的那个链表翻转，最后将两个链表拼接在一起
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        // 将链表一分为二：利用快慢指针，如果偶数个节点，则前后均分；如果奇数个节点，前面的会多一个
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode newHead = slowNode.next;
        slowNode.next = null;

        // 将后一个链表翻转，后一个链表的头结点为 newHead，链表翻转可以参考 Leetcode 0206
        newHead = reverseList(newHead);

        // 将两个链表交叉拼接在一起
        while (newHead != null) {
            ListNode node = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = node;
        }
    }

    private ListNode reverseList(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode rHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;

        return rHead;
    }

    public static void main(String[] args) {
        // 创建链表，获取链表头结点
//        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4})).getHead();
        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4, 5})).getHead();

        (new Solution()).reorderList(head);
        MyLinkedList.printLinkedList(head);
    }
}
