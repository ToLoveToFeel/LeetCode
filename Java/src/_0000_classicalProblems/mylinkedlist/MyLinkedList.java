package _0000_classicalProblems.mylinkedlist;

/**
 * Date: 2020/9/4 18:08
 * Content:
 */
public class MyLinkedList {
    private ListNode head;  // 链表头

    public MyLinkedList() {
        head = null;
    }

    public MyLinkedList(int[] nums) {
        this();
        head = createLinkedList(nums);
    }

    // 创建链表
    public ListNode createLinkedList(int[] nums) {
        if (0 == nums.length)
            return null;

        ListNode head = new ListNode(nums[0]);

        ListNode curNode = head;
        for (int i = 1; i < nums.length; i++) {
            curNode.next = new ListNode(nums[i]);
            curNode = curNode.next;
        }

        return head;
    }

    // 打印链表
    public void printLinkedList(ListNode head) {
        ListNode curNode = head;
        while (null != curNode) {
            System.out.print(curNode.val);
            System.out.print("->");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }
}
