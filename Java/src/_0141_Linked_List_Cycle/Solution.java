package _0141_Linked_List_Cycle;

import java.util.HashSet;

/**
 * Date: 2020/9/9 20:17
 * Content:
 */
public class Solution {

    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode curNode = head;
        while (curNode != null) {
            if (set.contains(curNode)) return true;
            else set.add(curNode);
            curNode = curNode.next;
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode head = (new MyLinkedList(new int[]{1, 2})).getHead();
        head.next.next = head;
        System.out.println((new Solution()).hasCycle(head));
    }
}
