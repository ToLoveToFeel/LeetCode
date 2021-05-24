# coding=utf-8
from MyLinkedList import *


class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if k == 0 or not head:
            return head

        n = 0
        tail = head; p = head
        while p:
            tail = p
            n += 1
            p = p.next
        k %= n
        if k == 0:
            return head

        p = head
        for i in range(n - 1 - k):
            p = p.next
        tail.next = head
        head = p.next
        p.next = None
        return head


if __name__ == "__main__":
    head = MyLinkedList().createLinkedList([1, 2, 3, 4, 5])
    MyLinkedList().printLinkedList(Solution().rotateRight(head, 2))  # 4->5->1->2->3->NULL
