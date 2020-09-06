package _0021_Merge_Two_Sorted_Lists;

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

    public ListNode getHead() {
        return head;
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

    public void printLinkedList() {
        printLinkedList(head);
    }

    // 打印链表
    public static void printLinkedList(ListNode head) {
        ListNode curNode = head;
        while (null != curNode) {
            System.out.print(curNode.val);
            System.out.print("->");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curNode = head;
        while (curNode != null) {
            sb.append(curNode.val);
            sb.append("->");
            curNode = curNode.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
