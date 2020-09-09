package _0160_Intersection_of_Two_Linked_Lists;

/**
 * Date: 2020/9/9 16:54
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int numA = 0, numB = 0;
        ListNode curA = headA, curB = headB;
        // 统计节点个数
        while (curA != null) {
            curA = curA.next;
            numA++;
        }
        while (curB != null) {
            curB = curB.next;
            numB++;
        }
        ListNode curL = numA > numB ? headA : headB;  // 长链表
        ListNode curS = numA > numB ? headB : headA;  // 短链表
        for (int i = 0; i < Math.abs(numA - numB); i++)
            curL = curL.next;

        while (curL != null) {
            if (curL == curS)
                break;
            curL = curL.next;
            curS = curS.next;
        }
        return curL;
    }

    public static void main(String[] args) {
        // 创建公共头结点
        ListNode commonHead = (new MyLinkedList(new int[]{8, 4, 5})).getHead();
        // 创建非公共链表
        ListNode headA = (new MyLinkedList(new int[]{4, 1})).getHead();
        ListNode headB = (new MyLinkedList(new int[]{5, 0, 1})).getHead();
        // 将headA和HeadB接上公共部分
        ListNode tailA = headA, tailB = headB;
        while (tailA.next != null)
            tailA = tailA.next;
        while (tailB.next != null)
            tailB = tailB.next;
        tailA.next = commonHead;
        tailB.next = commonHead;

        // 测试
        System.out.println((new Solution()).getIntersectionNode(headA, headB).val);
    }
}
