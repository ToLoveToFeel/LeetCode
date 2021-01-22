// Created by WXX on 2021/1/22 16:50
#include "MyLinkedList.h"

using namespace std;

/**
 * 执行用时：44 ms, 在所有 C++ 提交中击败了95.96%的用户
 * 内存消耗：14.3 MB, 在所有 C++ 提交中击败了96.30%的用户
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