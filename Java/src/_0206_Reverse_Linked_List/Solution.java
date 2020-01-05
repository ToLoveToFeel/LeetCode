package _0206_Reverse_Linked_List;

class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (null != cur){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
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
        head = solution.reverseList(head);
        // 输出链表
        solution.printLinkedList(head);
    }
}
