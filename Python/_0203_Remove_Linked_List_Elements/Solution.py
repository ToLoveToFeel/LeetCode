# coding=utf-8
# Date: 2021/6/5 14:06
from MyLinkedList import *


# 执行用时：76 ms, 在所有 Python3 提交中击败了44.93%的用户
# 内存消耗：25.9 MB, 在所有 Python3 提交中击败了5.02%的用户
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        if not head:
            return None
        head.next = self.removeElements(head.next, val)
        return head.next if head.val == val else head


if __name__ == "__main__":
    head = MyLinkedList().createLinkedList([1, 2, 3, 4, 5, 6])
    MyLinkedList().printLinkedList(Solution().removeElements(head, 6))
