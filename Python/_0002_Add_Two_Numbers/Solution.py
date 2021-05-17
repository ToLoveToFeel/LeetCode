# coding=utf-8
from MyLinkedList import *


# 执行用时：68 ms, 在所有 Python3 提交中击败了66.53%的用户
# 内存消耗：14.7 MB, 在所有 Python3 提交中击败了96.76%的用户
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode()
        cur = dummy
        t = 0
        while l1 or l2 or t:
            if l1:
                t += l1.val
                l1 = l1.next
            if l2:
                t += l2.val
                l2 = l2.next
            cur.next = ListNode(t % 10)
            cur = cur.next
            t //= 10
        return dummy.next


if __name__ == "__main__":
    l1 = MyLinkedList().createLinkedList([2, 4, 3])
    l2 = MyLinkedList().createLinkedList([5, 6, 4])
    MyLinkedList().printLinkedList(Solution().addTwoNumbers(l1, l2))  # 7->0->8->NULL
