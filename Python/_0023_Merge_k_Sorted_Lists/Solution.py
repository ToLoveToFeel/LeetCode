# coding=utf-8
from typing import List
from MyLinkedList import *


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return None
        step = 1
        while step < len(lists):
            i = 0
            while i + step < len(lists):
                lists[i] = self.merge(lists[i], lists[i + step])
                i += step + step
            step += step
        return lists[0]

    def merge(self, l1, l2):
        if not l1:
            return l2
        if not l2:
            return l1
        if l1.val < l2.val:
            l1.next = self.merge(l1.next, l2)
            return l1
        else:
            l2.next = self.merge(l1, l2.next)
            return l2


if __name__ == "__main__":
    l1 = MyLinkedList().createLinkedList([1, 4, 5])
    l2 = MyLinkedList().createLinkedList([1, 3, 4])
    l3 = MyLinkedList().createLinkedList([2, 6])
    lists = [l1, l2, l3]
    MyLinkedList().printLinkedList(Solution().mergeKLists(lists))  # 1->1->2->3->4->4->5->6->NULL
