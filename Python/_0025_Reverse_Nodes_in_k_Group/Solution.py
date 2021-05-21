# coding=utf-8
from MyLinkedList import *


# 执行用时：60 ms, 在所有 Python3 提交中击败了26.66%的用户
# 内存消耗：15.6 MB, 在所有 Python3 提交中击败了29.84%的用户
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode()
        dummy.next = head
        p = dummy
        while True:
            q = p
            for i in range(k):
                if not q:
                    break
                q = q.next
            if not q:  # 说明后面不足k个元素
                break
            a = p.next; b = a.next
            for i in range(k - 1):
                c = b.next
                b.next = a
                a = b; b = c
            c = p.next
            p.next = a; c.next = b
            p = c
        return dummy.next


if __name__ == "__main__":
    head = MyLinkedList().createLinkedList([1, 2, 3, 4, 5])
    MyLinkedList().printLinkedList(Solution().reverseKGroup(head, 3))  # 3->2->1->4->5->NULL
