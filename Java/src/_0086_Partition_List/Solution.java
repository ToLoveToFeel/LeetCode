package _0086_Partition_List;

/**
 * Date: 2020/10/11 10:36
 * Content: 虚拟头结点
 * 用两个链表记录：小于 x 的节点，大于或等于 x 的节点
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了38.16%的用户
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null)
            return head;

        ListNode dummyHead1 = new ListNode(0);  // 记录 小于 x 的节点
        ListNode dummyHead2 = new ListNode(0);  // 记录 大于或等于 x 的节点

        ListNode curNode = head;
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (curNode != null) {
            if (curNode.val < x) {
                node1.next = curNode;
                node1 = curNode;
                curNode = curNode.next;
                node1.next = null;
            } else {
                node2.next = curNode;
                node2 = curNode;
                curNode = curNode.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;

        return dummyHead1.next;
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
        ListNode head = (new MyLinkedList(new int[]{1, 4, 3, 2, 5, 2})).getHead();
        head = (new Solution()).partition(head, 3);
        MyLinkedList.printLinkedList(head);
    }
}
