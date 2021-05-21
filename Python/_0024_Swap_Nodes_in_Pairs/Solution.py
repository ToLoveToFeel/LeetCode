# coding=utf-8
from MyLinkedList import *


# 执行用时：28 ms, 在所有 Python3 提交中击败了99.06%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了77.70%的用户
# 递归写法
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        newHead = head.next
        head.next = self.swapPairs(head.next.next)
        newHead.next = head
        return newHead


if __name__ == "__main__":
    head = MyLinkedList().createLinkedList([1, 2, 3, 4])
    MyLinkedList().printLinkedList(head)  # 1->2->3->4->NULL
