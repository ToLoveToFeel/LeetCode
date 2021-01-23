package _0142_Linked_List_Cycle_II;

/**
 * Date: 2020/9/9 20:45
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution2 {

    // 双指针（一快一慢）
    public ListNode detectCycle(ListNode head) {

        ListNode slowNode = head;
        ListNode fastNode = head;

        while (true) {
            if (fastNode == null || fastNode.next == null) return null;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) break;  // 第一次相遇
        }
        slowNode = head;
        while (slowNode != fastNode) {  // 第二次相遇
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {

        ListNode head = (new MyLinkedList(new int[]{1, 2})).getHead();
        head.next.next = head;
        ListNode res = (new Solution2()).detectCycle(head);
        System.out.println(res != null ? res.val : "null");
    }
}
