# coding=utf-8
from MyLinkedList import *


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2


if __name__ == "__main__":
    l1 = MyLinkedList().createLinkedList([1, 2, 4])
    l2 = MyLinkedList().createLinkedList([1, 3, 4])
    MyLinkedList().printLinkedList(Solution().mergeTwoLists(l1, l2))  # 1->1->2->3->4->4->NULL
