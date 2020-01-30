package _0092_Reverse_Linked_List_II;

public class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode left = new ListNode(0);  // 第n+1个结点

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        for (int i = 0; i < m - 1; i++, pre = pre.next);

        ListNode tail = pre.next;  // 翻转后链表的结尾

        pre.next = reverse(pre.next, n - m);
        tail.next = left;

        return dummyHead.next;
    }

    // 返回反转后链表头指针
    private ListNode reverse(ListNode head, int index){
        if (0 == index){
            left = head.next;
            return head;
        }

        ListNode tail = head.next;
        ListNode ret = reverse(head.next, index - 1);
        tail.next = head;
        return ret;
    }

    // 创建链表
    public ListNode createLinkedList(int[] arr){
        if (0 == arr.length)
            return null;

        ListNode head = new ListNode(arr[0]);

        ListNode curNode = head;
        for (int i = 1; i < arr.length; i++){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }

        return head;
    }

    // 打印链表
    public void printLinkedList(ListNode head){
        ListNode curNode = head;
        while (null != curNode){
            System.out.print(curNode.val);
            System.out.print("->");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Solution solution = new Solution();

        // 创建链表
        ListNode head = solution.createLinkedList(arr);
        solution.printLinkedList(head);
        // 翻转链表
        head = solution.reverseBetween(head, 2, 4);
        // 输出链表
        solution.printLinkedList(head);
    }
}
