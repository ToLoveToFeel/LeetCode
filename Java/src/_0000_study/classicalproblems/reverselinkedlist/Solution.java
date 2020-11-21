package _0000_study.classicalproblems.reverselinkedlist;

class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        // 创建链表
        MyLinkedList myLinkedList = new MyLinkedList(nums);
        ListNode head = myLinkedList.getHead();
        myLinkedList.printLinkedList(head);
        // 翻转链表
        head = (new Solution()).reverseList(head);
        // 输出链表
        myLinkedList.printLinkedList(head);
    }
}
