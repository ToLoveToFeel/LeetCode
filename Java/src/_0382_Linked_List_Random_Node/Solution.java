package _0382_Linked_List_Random_Node;

import java.util.Random;

/**
 * Date: 2021/5/29 18:42
 * 执行用时：16 ms, 在所有 Java 提交中击败了47.95%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了94.63%的用户
 */
public class Solution {

    ListNode h;
    Random random = new Random();

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        h = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = 0, n = 0;
        for (ListNode p = h; p != null; p = p.next) {
            n++;
            if (random.nextInt(Integer.MAX_VALUE) % n == 0) res = p.val;
        }
        return res;
    }

    public static void main(String[] args) {

        ListNode head = (new MyLinkedList(new int[]{1, 2, 3})).getHead();
        System.out.println((new Solution(head)).getRandom());
        System.out.println((new Solution(head)).getRandom());
        System.out.println((new Solution(head)).getRandom());
    }
}
