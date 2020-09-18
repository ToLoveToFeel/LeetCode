package _0000_study._auxiliary.mylinkedlist;

/**
 * Date: 2020/9/6 10:46
 * Content:
 */
public class Test {
    public static void main(String[] args) {
//        // 创建链表
//        int[] nums = {1, 2, 4};
//        MyLinkedList list = new MyLinkedList(nums);
//        // 获取链表头结点
//        ListNode head = list.getHead();
//        // 输出链表
//        list.printLinkedList(head);

        // 创建链表，获取链表头结点
        ListNode head = (new MyLinkedList(new int[]{1, 2, 4})).getHead();
    }
}
