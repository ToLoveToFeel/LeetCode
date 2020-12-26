package _0082_Remove_Duplicates_from_Sorted_List_II;

/**
 * Date: 2020/10/2 10:40
 * Content:
 * 画个图就明白了
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 创建三个游标
        ListNode preNode = dummyHead;
        ListNode curNode = head;
        ListNode nextNode = curNode.next;

        while (nextNode != null) {
            while (nextNode != null && curNode.val == nextNode.val) {
                nextNode = nextNode.next;
            }
            if (curNode.next != nextNode)  // 说明存在重复
                preNode.next = nextNode;
            else  // 说明不存在重复
                preNode = curNode;
            curNode = nextNode;
            if (nextNode != null)
                nextNode = nextNode.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

//        ListNode head = (new MyLinkedList(new int[]{1, 1, 2, 3, 3, 4})).getHead();
//        ListNode head = (new MyLinkedList(new int[]{1, 1, 1})).getHead();
//        ListNode head = (new MyLinkedList(new int[]{1, 1, 1, 2, 3})).getHead();
//        ListNode head = (new MyLinkedList(new int[]{1, 2, 3, 4, 5})).getHead();
        ListNode head = (new MyLinkedList(new int[]{1, 2, 2, 2, 5})).getHead();
        head = (new Solution()).deleteDuplicates(head);
        MyLinkedList.printLinkedList(head);
    }
}
