package _0328_Odd_Even_Linked_List;

/**
 * Date: 2020/11/13 10:10
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了93.29%的用户
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        // 检查链表是否需要进行处理，如果节点太少(小于等于2个)直接返回
        if (head == null || head.next == null || head.next.next == null)
            return head;

        // 第一步：新建两个链表，分别存放奇数节点和偶数节点
        ListNode oddHead = head;
        ListNode evenHead = head.next;


        head = head.next.next;
        evenHead.next = null;
        oddHead.next = null;

        ListNode curOddNode = oddHead;
        ListNode curEvenNode = evenHead;

        int index = 3;
        while (head != null) {
            if ((index & 1) == 1) {
                curOddNode.next = head;
                head = head.next;
                curOddNode = curOddNode.next;
                curOddNode.next = null;
            } else {
                curEvenNode.next = head;
                head = head.next;
                curEvenNode = curEvenNode.next;
                curEvenNode.next = null;
            }
            index++;
        }

        // 第二步：将两个链表拼接在一起，返回
        curOddNode.next = evenHead;

        return oddHead;
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
//        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4, 5})).getHead();  // 1->3->5->2->4->NULL
        ListNode head = (new MyLinkedList(new int[]{2, 1, 3, 5, 6, 4, 7})).getHead();  // 2->3->6->7->1->5->4->NULL
        head = (new Solution()).oddEvenList(head);

        MyLinkedList.printLinkedList(head);
    }
}
