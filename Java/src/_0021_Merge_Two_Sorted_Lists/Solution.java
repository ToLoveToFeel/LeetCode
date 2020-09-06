package _0021_Merge_Two_Sorted_Lists;

/**
 * Date: 2020/8/29 20:10
 * Content:
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        // 将l2插入到l1中
        ListNode dummyHead = new ListNode(-1, l1);
        ListNode pre = dummyHead;
        ListNode p = l1;  // 指针追踪l1
        ListNode q = l2;  // 指针追踪l2
        while (p != null && q != null) {
            if (p.val < q.val) {  // 链表l1不断向下走
                pre = p;
                p = p.next;
            } else {  // 插入到p之前，pre之后
                ListNode temp = q;
                q = q.next;
                temp.next = p;
                pre.next = temp;
                pre = pre.next;
            }
        }
        if (q != null) {
            pre.next = q;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // 创建链表，获取链表头结点
        ListNode l1 = (new MyLinkedList(new int[]{1, 2, 4})).getHead();
        // 创建链表，获取链表头结点
        ListNode l2 = (new MyLinkedList(new int[]{1, 3, 4})).getHead();
        l1 = (new Solution()).mergeTwoLists(l1, l2);
        MyLinkedList.printLinkedList(l1);
    }
}
