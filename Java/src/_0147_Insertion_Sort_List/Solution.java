package _0147_Insertion_Sort_List;

/**
 * Date: 2020/11/20 10:23
 * Content:
 * 执行用时：3 ms, 在所有 Java 提交中击败了98.81%的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了81.97%的用户
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null)  // 链表没有或者只有一个节点
            return head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 初始化
        ListNode curNode = head.next;
        ListNode preNode = head;
        while (curNode != null) {
            if (preNode.val <= curNode.val) {
                preNode = curNode;
                curNode = curNode.next;
                continue;
            }
            // 需要找到要插入的位置
            preNode.next = curNode.next;
            ListNode p = dummyHead;
            while (p.next.val < curNode.val) {
                p = p.next;
            }
            // 将数据插入到p的后面
            curNode.next = p.next;
            p.next = curNode;
            // 更新curNode，进行下一次循环
            curNode = preNode.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
//        ListNode head = (new MyLinkedList(new int[]{6, 5, 3, 1, 8, 7, 2, 4})).getHead();
//        ListNode head = (new MyLinkedList(new int[]{4, 2, 1, 3})).getHead();
        ListNode head = (new MyLinkedList(new int[]{-1, 5, 3, 4, 0})).getHead();
        head = (new Solution()).insertionSortList(head);
        MyLinkedList.printLinkedList(head);
    }
}
