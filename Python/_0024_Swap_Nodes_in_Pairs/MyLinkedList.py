# coding=utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MyLinkedList:
    # head = MyLinkedList().createLinkedList([1, 2, 3])
    def __int__(self):
        pass

    def createLinkedList(self, nums):
        if len(nums) == 0:
            return None

        head = ListNode(nums[0])
        cur = head
        for i in range(1, len(nums)):
            cur.next = ListNode(nums[i])
            cur = cur.next

        return head

    def printLinkedList(self, head):
        cur = head
        while cur:
            print(cur.val, "->", sep="", end="")  # sep取消空格，end取消回车
            cur = cur.next
        print("NULL")
