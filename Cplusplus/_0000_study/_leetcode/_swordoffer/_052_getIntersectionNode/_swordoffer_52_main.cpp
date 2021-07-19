// Created by WXX on 2021/7/19 20:12
#include "MyLinkedList.h"

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了95.33%的用户
 * 内存消耗：14.1 MB, 在所有 C++ 提交中击败了95.08%的用户
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        auto p = headA, q = headB;
        while (p != q) {
            p = p ? p->next : headB;
            q = q ? q->next : headA;
        }
        return p;
    }
};

int main() {

    // 创建公共头结点
    ListNode *commonHead = MyLinkedList({8, 4, 5}).getHead();
    // 创建非公共链表
    ListNode *headA = MyLinkedList({4, 1}).getHead();
    ListNode *headB = MyLinkedList({5, 0, 1}).getHead();
    // 将headA和HeadB接上公共部分
    auto p = headA, q = headB;
    while (p->next != NULL) p = p->next;
    while (q->next != NULL) q = q->next;
    p->next = commonHead, q->next = commonHead;

    cout << Solution().getIntersectionNode(headA, headB)->val << endl;  // 8

    return 0;
}
