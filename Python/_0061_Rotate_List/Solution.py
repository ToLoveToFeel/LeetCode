# coding=utf-8
# @Time       : 2020/3/4
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode
# 旋转链表


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    """
        1、这道题的首先遍历一遍链表，将链表的尾部和头部串联起来，并且获取到链表的长度；
        2、根据k、链表长度计算链表在哪个位置应该断开，断开后的下一个Node就是我们需要的结果。
    """
    def __init__(self, head):
        self.head = head
        self.newHead = head

    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head is None:
            return head
        if k == 0:
            return head

        # 1、这道题的首先遍历一遍链表，将链表的尾部和头部串联起来，并且获取到链表的长度；
        ori_head = head
        n = 1  # 链表长度
        while head.next:
            head = head.next
            n += 1
        head.next = ori_head  # 将链表前后连上
        # 2、根据k、链表长度计算链表在哪个位置应该断开，断开后的下一个Node就是我们需要的结果。
        moveNum = (n-k % n) - 1
        while moveNum > 0:
            ori_head = ori_head.next
            moveNum -= 1
        newHead = ori_head.next
        ori_head.next = None
        self.newHead = newHead

        return newHead

    def __str__(self):
        s = ""
        if self.newHead:
            s = str(self.newHead.val)
        else:
            return s
        cur = self.newHead.next
        while cur:
            s += "->" + str(cur.val)
            cur = cur.next
        s += "->NULL"
        return s


if __name__ == "__main__":
    # 创建链表
    head = ListNode(1)
    next1 = ListNode(2)
    next2 = ListNode(3)
    next3 = ListNode(4)
    next4 = ListNode(5)
    head.next = next1
    next1.next = next2
    next2.next = next3
    next3.next = next4

    k = 1

    So = Solution(head)
    print(So)
    So.rotateRight(head, k)
    print(So)


