# coding=utf-8
from MyLinkedList import *


# 执行用时：40 ms, 在所有 Python3 提交中击败了74.83%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了15.47%的用户
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode()
        dummy.next = head
        p = dummy; q = dummy

        for i in range(n + 1):
            q = q.next
        while q:
            p = p.next
            q = q.next

        p.next = p.next.next

        return dummy.next


if __name__ == "__main__":
    head = MyLinkedList().createLinkedList([1, 2, 3, 4, 5])
    MyLinkedList().printLinkedList(Solution().removeNthFromEnd(head, 2))  # 1->2->3->5->NULL
