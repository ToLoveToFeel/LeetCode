package _0023_Merge_k_Sorted_Lists;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by WXX on 2021/3/1 19:24
 * 执行用时：8 ms, 在所有 Java 提交中击败了38.24%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了27.58%的用户
 */
public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        ListNode dummy = new ListNode(-1), tail = dummy;
        for (ListNode l : lists)
            if (l != null)
                heap.add(l);
        while (!heap.isEmpty()) {
            ListNode t = heap.remove();

            tail = tail.next = t;
            if (t.next != null) heap.add(t.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
        ListNode l1 = (new MyLinkedList(new int[]{1, 4, 5})).getHead();
        ListNode l2 = (new MyLinkedList(new int[]{1, 3, 4})).getHead();
        ListNode l3 = (new MyLinkedList(new int[]{2, 6})).getHead();
        ListNode[] lists = {l1, l2, l3};
//        ListNode l1 = (new MyLinkedList(new int[]{})).getHead();
//        ListNode l2 = (new MyLinkedList(new int[]{1})).getHead();
//        ListNode[] lists = {l1, l2};
        ListNode l = (new Solution2()).mergeKLists(lists);
        MyLinkedList.printLinkedList(l);
    }
}
