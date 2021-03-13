// Created by WXX on 2021/3/13 21:10
#include "MyLinkedList.h"

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了75.03%的用户
 * 内存消耗：11.1 MB, 在所有 C++ 提交中击败了87.35%的用户
 */
class Solution {
public:
    ListNode *reverseKGroup(ListNode *head, int k) {
        auto dummy = new ListNode(-1);
        dummy->next = head;
        for (auto p = dummy;;) {
            auto q = p;
            for (int i = 0; i < k && q; i++) q = q->next;
            if (!q) break;
            auto a = p->next, b = a->next;
            for (int i = 0; i < k - 1; i++) {
                auto c = b->next;
                b->next = a;
                a = b, b = c;
            }
            auto c = p->next;
            p->next = a, c->next = b;
            p = c;
        }
        return dummy->next;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 4, 5}).getHead();
    MyLinkedList().printLinkedList(Solution().reverseKGroup(head, 2));

    return 0;
}
