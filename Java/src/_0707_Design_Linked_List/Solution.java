package _0707_Design_Linked_List;

/**
 * Date: 2020/9/21 10:01
 * Content:
 * 链表的实现：单链表
 */
public class Solution {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));  // 2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));  // 3
    }
}

class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private final ListNode dummyHead;  // 虚拟头结点
    private int size;  // 链表节点个数

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        dummyHead = new ListNode(-1);
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        ListNode curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;

        if (index < 0)  // index < 0 插入到头部
            index = 0;

        ListNode preNode = dummyHead;
        for (int i = 0; i < index; i++)
            preNode = preNode.next;

        ListNode newNode = new ListNode(val, preNode.next);
        preNode.next = newNode;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        ListNode preNode = dummyHead;
        for (int i = 0; i < index; i++)
            preNode = preNode.next;

        preNode.next = preNode.next.next;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curNode = dummyHead.next;
        while (curNode != null) {
            sb.append(curNode.val);
            sb.append("->");
            curNode = curNode.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
