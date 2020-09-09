package _0142_Linked_List_Cycle_II;

import java.util.HashSet;

/**
 * Date: 2020/9/9 20:45
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curNode = head;
        while (curNode != null) {
            if (set.contains(curNode))
                return curNode;
            else
                set.add(curNode);
            curNode = curNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = (new MyLinkedList(new int[]{1, 2})).getHead();
        head.next.next = head;
        ListNode res = (new Solution()).detectCycle(head);
        System.out.println(res != null ? res.val : "null");
    }
}
