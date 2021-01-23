package _0141_Linked_List_Cycle;

/**
 * Date: 2020/9/9 20:17
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution2 {

    // 双指针（一快一慢）
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slowNode = head;
        ListNode fastNode = head;
        while (true) {
            if (fastNode == null || fastNode.next == null) return false;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) return true;
        }
    }

    public static void main(String[] args) {

        ListNode head = (new MyLinkedList(new int[]{1, 2})).getHead();
        head.next.next = head;
        System.out.println((new Solution2()).hasCycle(head));
    }
}
