// Created by WXX on 2021/2/22 23:50
#include "MyLinkedList.h"

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了84.72%的用户
 * 内存消耗：10.2 MB, 在所有 C++ 提交中击败了88.98%的用户
 */
class Solution {
public:
    ListNode *oddEvenList(ListNode *head) {

        if (!head || !head->next) return head;

        auto oh = head, ot = oh;
        auto eh = head->next, et = eh;
        for (auto p = head->next->next; p; ) {
            ot = ot->next = p;
            p = p->next;
            if (p) {
                et = et->next = p;
                p = p->next;
            }
        }
        ot->next = eh;
        et->next = NULL;
        return oh;
    }
};

int main() {

    ListNode *head = MyLinkedList({2, 1, 3, 5, 6, 4, 7}).getHead();  // 2->3->6->7->1->5->4->NULL
    head = Solution().oddEvenList(head);
    MyLinkedList().printLinkedList(head);

    return 0;
}
