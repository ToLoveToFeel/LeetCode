package _0160_Intersection_of_Two_Linked_Lists;

/**
 * Date: 2020/9/9 16:54
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 这是一种有趣的解题方式，我走过你走过的路
 * 如果没有相交，则会运行headA.size()+headB.size()+1次，然后curA == curB = null 结束
 */
public class Solution2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p = headA, q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }

    public static void main(String[] args) {

        // 创建公共头结点
        ListNode commonHead = (new MyLinkedList(new int[]{8, 4, 5})).getHead();
        // 创建非公共链表
        ListNode headA = (new MyLinkedList(new int[]{4, 1})).getHead();
        ListNode headB = (new MyLinkedList(new int[]{5, 0, 1})).getHead();
        // 将headA和HeadB接上公共部分
        ListNode p = headA, q = headB;
        while (p.next != null) p = p.next;
        while (q.next != null) q = q.next;
        p.next = commonHead;
        q.next = commonHead;

        // 测试
        System.out.println((new Solution2()).getIntersectionNode(headA, headB).val);  // 8
    }
}
